package com.ms.spring.integration.jms;

import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.jms.*;
import org.apache.log4j.Logger;


public class JmsMessageProducer {

    private static final Logger logger = Logger.getLogger(MessageProducer.class);

    @Autowired
    JmsGateway jmsGateway;

    /**
     * Generate JMS message
     */
    final static String MSG_SENT = "Message has been sent to AMQ queue.";

    public void sendMessageFromSFDC(final Object message) throws Exception, JMSException {

        // MessageMap to JSON convertion
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonText = gson.toJson(message);
        //logger.info("## Converted to JSON: " + json);

        // Get Salesforce object ID
        JsonParser jsonParser = new JsonParser();
        JsonObject sobject = jsonParser.parse(jsonText).getAsJsonObject().get("data").getAsJsonObject().get("sobject").getAsJsonObject();
        String id = sobject.get("Id").getAsString();
        //logger.info("## Salesforce object Id: " + id);
        jmsGateway.sendMessage("sfdc", id, jsonText);
        logger.debug(MSG_SENT);
        System.out.println(MSG_SENT);
    }

/*    public void sendMessageToSFDC(final Object message) throws Exception, JMSException {
        //logger.info("## Salesforce object Id: " + id);
        jmsGateway.sendMessage("file", "", "");
        logger.debug(MSG_SENT);
        System.out.println(MSG_SENT);
    }*/

}