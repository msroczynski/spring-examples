package com.ms.demo.sfdc;


public class StreamingClientExample {


    public static void main(String[] args) throws Exception {

        StreamingClientWorker scw = new StreamingClientWorker();

        scw.runListener();

    }


}

