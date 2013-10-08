package com.ms.spring.integration.adapter.sfdc;


import com.ms.spring.integration.util.PropertiesProvider;
import com.ms.spring.integration.jms.JmsMessageProducer;
import org.cometd.bayeux.Channel;
import org.cometd.bayeux.Message;
import org.cometd.bayeux.client.ClientSessionChannel;
import org.cometd.bayeux.client.ClientSessionChannel.MessageListener;
import org.cometd.client.BayeuxClient;
import org.cometd.client.transport.ClientTransport;
import org.cometd.client.transport.LongPollingTransport;

import org.eclipse.jetty.client.ContentExchange;
import org.eclipse.jetty.client.HttpClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * This example demonstrates how a streaming client works
 * against the Salesforce Streaming API.
 **/
public class StreamingClientWorker {


    // Set this to true only when using this client
    // against the Summer'11 release (API version=22.0).
    private static final boolean VERSION_22 = false;
    private static final boolean USE_COOKIES = VERSION_22;

    private String CHANNEL;

    private static final String STREAMING_ENDPOINT_URI = VERSION_22 ? "/cometd" : "/cometd/26.0";

    // The long poll duration.
    private static final int CONNECTION_TIMEOUT = 20 * 1000;  // milliseconds
    private static final int READ_TIMEOUT = 120 * 1000; // milliseconds

    private ApplicationContext ctx = null;

    private PropertiesProvider prop = null;

    public StreamingClientWorker() {
        ctx = new ClassPathXmlApplicationContext(new String[] {"spring-context.xml","spring-integration.xml"});
        prop = (PropertiesProvider)ctx.getBean("properties");
        CHANNEL = VERSION_22 ? "/"+prop.getSfdcPushTopicAcct() : "/topic/"+prop.getSfdcPushTopicAcct();
    }

    public void runListener() throws Exception {

        System.out.println("Running streaming client example....");

        final BayeuxClient client = makeClient();
        client.getChannel(Channel.META_HANDSHAKE).addListener
                (new ClientSessionChannel.MessageListener() {

                    public void onMessage(ClientSessionChannel channel, Message message) {

                        System.out.println("[CHANNEL:META_HANDSHAKE]: " + message);

                        boolean success = message.isSuccessful();
                        if (!success) {
                            String error = (String) message.get("error");
                            if (error != null) {
                                System.out.println("Error during HANDSHAKE: " + error);
                                System.out.println("Exiting...");
                                System.exit(1);
                            }

                            Exception exception = (Exception) message.get("exception");
                            if (exception != null) {
                                System.out.println("Exception during HANDSHAKE: ");
                                exception.printStackTrace();
                                System.out.println("Exiting...");
                                System.exit(1);

                            }
                        }
                    }

                });

        client.getChannel(Channel.META_CONNECT).addListener(
                new ClientSessionChannel.MessageListener() {
                    public void onMessage(ClientSessionChannel channel, Message message) {

                        System.out.println("[CHANNEL:META_CONNECT]: " + message);

                        boolean success = message.isSuccessful();
                        if (!success) {
                            String error = (String) message.get("error");
                            if (error != null) {
                                System.out.println("Error during CONNECT: " + error);
                                System.out.println("Exiting...");
                                System.exit(1);
                            }
                        }
                    }

                });

        client.getChannel(Channel.META_SUBSCRIBE).addListener(
                new ClientSessionChannel.MessageListener() {

                    public void onMessage(ClientSessionChannel channel, Message message) {

                        System.out.println("[CHANNEL:META_SUBSCRIBE]: " + message);
                        boolean success = message.isSuccessful();
                        if (!success) {
                            String error = (String) message.get("error");
                            if (error != null) {
                                System.out.println("Error during SUBSCRIBE: " + error);
                                System.out.println("Exiting...");
                                System.exit(1);
                            }
                        }
                    }
                });



        client.handshake();
        System.out.println("Waiting for handshake");

        boolean handshaken = client.waitFor(10 * 1000, BayeuxClient.State.CONNECTED);
        if (!handshaken) {
            System.out.println("Failed to handshake: " + client);
            System.exit(1);
        }

        System.out.println("Subscribing for channel: " + CHANNEL);

        client.getChannel(CHANNEL).subscribe(new MessageListener() {
            @Override
            public void onMessage(ClientSessionChannel channel, Message message) {
                System.out.println("Received Message: " + message);
/*                try {
                    MessageProducer mp = (MessageProducer)ctx.getBean("messageProducer");
                    mp.send(message);
                }
                catch (JMSException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    e.printStackTrace();
                }*/

                JmsMessageProducer jmsMP = (JmsMessageProducer)ctx.getBean("jmsMessageProducer");
                try {
                    jmsMP.sendMessage(message);
                } catch (Exception e) {
                    System.out.println("Error sending JMS message: " + e.getMessage());
                }
            }
        });

        System.out.println("Waiting for streamed data from your organization ...");

    }

    // TODO removed static keyword from the method declaration
    private  BayeuxClient makeClient() throws Exception {
        HttpClient httpClient = new HttpClient();
        httpClient.setConnectTimeout(CONNECTION_TIMEOUT);
        httpClient.setTimeout(READ_TIMEOUT);
        httpClient.start();

        String[] pair = SoapLoginUtil.login(httpClient, new URL(prop.getSfdcLoginURL() + prop.getSfdcSoapPartnerEndpoint() + prop.getSfdcSoapApiVersion() + "/").toExternalForm(), prop.getSfdcUsername(), prop.getSfdcPassword());

        if (pair == null) {
            System.exit(1);
        }

        assert pair.length == 2;
        final String sessionid = pair[0];
        String endpoint = pair[1];
        System.out.println("Login successful!\nEndpoint: " + endpoint
                + "\nSessionid: " + sessionid);

        Map<String, Object> options = new HashMap<String, Object>();
        options.put(ClientTransport.TIMEOUT_OPTION, READ_TIMEOUT);
        LongPollingTransport transport = new LongPollingTransport(
                options, httpClient) {

            @Override
            protected void customize(ContentExchange exchange) {
                super.customize(exchange);
                exchange.addRequestHeader("Authorization", "OAuth " + sessionid);
            }
        };

        BayeuxClient client = new BayeuxClient(salesforceStreamingEndpoint(
                endpoint), transport);
        if (USE_COOKIES) establishCookies(client, prop.getSfdcUsername(), sessionid);
        return client;
    }

    private static String salesforceStreamingEndpoint(String endpoint)
            throws MalformedURLException {
        return new URL(endpoint + STREAMING_ENDPOINT_URI).toExternalForm();
    }

    private static void establishCookies(BayeuxClient client, String user,
                                         String sid) {
        client.setCookie("com.salesforce.LocaleInfo", "us", 24 * 60 * 60 * 1000);
        client.setCookie("login", user, 24 * 60 * 60 * 1000);
        client.setCookie("sid", sid, 24 * 60 * 60 * 1000);
        client.setCookie("language", "en_US", 24 * 60 * 60 * 1000);
    }
}

