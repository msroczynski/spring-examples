package com.ms.demo.sfdc;

import java.io.File;

import org.springframework.integration.Message;
import org.springframework.integration.file.DefaultFileNameGenerator;


public class FileNameGenerator extends  DefaultFileNameGenerator
{
    public FileNameGenerator() {
        super();
    }
    @Override
    public String generateFileName(Message<?> message) {
        File inputFile = (File)message.getPayload();
        String originalFileName = super.generateFileName(message);
        System.out.println("File Name: " + originalFileName);
        //TODO: Read the file
        //TODO: Write the file
        String newFileName = "NewFile";
        return newFileName;
    }
}