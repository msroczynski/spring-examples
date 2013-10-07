package com.ms.demo.sfdc;

import org.apache.log4j.Logger;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class MessageConsumer implements MessageListener {

    private static final Logger logger = Logger.getLogger(MessageConsumer.class);

    private static final String MSG_RECEIVED = "Message has been consumed from AMQ queue.";

    public void onMessage(final Message message) {
        logger.debug(MSG_RECEIVED);
        System.out.println(MSG_RECEIVED);

        if (message instanceof MapMessage) {
            final MapMessage mapMessage = (MapMessage) message;
        }
    }

}