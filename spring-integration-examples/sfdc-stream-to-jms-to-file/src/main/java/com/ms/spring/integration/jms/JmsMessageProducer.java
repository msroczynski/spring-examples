package com.ms.spring.integration.jms;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

    public void sendMessage(final Object message) throws Exception, JMSException {

        // MessageMap to JSON convertion
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(message);
        logger.info("## Converted to JSON: " + json);
        jmsGateway.sendMessage("sfdc",json);
        logger.debug(MSG_SENT);
        System.out.println(MSG_SENT);

    }


}
