package com.example.ex_4_hw.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;


public interface FileGateway {
//    void writeToFile(@Header(FileHeaders.FILENAME) String fileName, String data);
    void writeToFile(String fileName, String data);

}
