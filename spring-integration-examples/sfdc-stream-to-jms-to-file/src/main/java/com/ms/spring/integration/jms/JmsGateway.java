package com.ms.spring.integration.jms;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.Header;


public interface JmsGateway {

    @Gateway
    public void sendMessage(@Header("system") String s, Object o);

}