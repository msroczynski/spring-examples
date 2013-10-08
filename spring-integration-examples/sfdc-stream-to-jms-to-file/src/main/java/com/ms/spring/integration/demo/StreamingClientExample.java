package com.ms.spring.integration.demo;


import com.ms.spring.integration.adapter.sfdc.StreamingClientWorker;

public class StreamingClientExample {


    public static void main(String[] args) throws Exception {

        StreamingClientWorker scw = new StreamingClientWorker();

        scw.runListener();

    }


}

