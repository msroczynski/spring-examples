package com.ms.demo.sfdc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.log4j.Logger;

@Component
public class MessageProducer {


    private static final Logger logger = Logger.getLogger(MessageProducer.class);

    @Autowired
    private JmsTemplate producerTemplate;

    /**
     * Generate JMS message
     */
    final static String MSG_SENT = "Message has been sent to AMQ queue.";

    public void send(final Object inputMessage) throws Exception, JMSException {

        producerTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage(inputMessage.toString());
                return message;
            }
        });
        logger.debug(MSG_SENT);
        System.out.println(MSG_SENT);
    }
}
