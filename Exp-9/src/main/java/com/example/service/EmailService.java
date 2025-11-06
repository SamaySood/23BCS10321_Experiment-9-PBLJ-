package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService implements MessageService {
    
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("Email sent to " + recipient);
        System.out.println("Message: " + message);
    }
}
