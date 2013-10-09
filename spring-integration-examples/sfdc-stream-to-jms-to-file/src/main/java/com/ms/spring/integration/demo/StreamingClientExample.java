package com.ms.spring.integration.demo;


import com.ms.spring.integration.adapter.sfdc.StreamingClientWorker;

public class StreamingClientExample {


    public static void main(String[] args) {

        try {
            StreamingClientWorker scw = new StreamingClientWorker();
            scw.runListener();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }


}

