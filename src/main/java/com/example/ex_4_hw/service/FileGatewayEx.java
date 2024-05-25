package com.example.ex_4_hw.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "textInputChannel")
public interface FileGatewayEx extends FileGateway{
    @Override
    void writeToFile(@Header(FileHeaders.FILENAME) String fileName, String data);
}
