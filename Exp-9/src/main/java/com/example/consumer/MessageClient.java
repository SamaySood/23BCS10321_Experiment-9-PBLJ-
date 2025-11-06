package com.example.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.service.MessageService;

@Component
public class MessageClient {
    
    private MessageService messageService;
    
    @Autowired
    public MessageClient(MessageService messageService) {
        this.messageService = messageService;
    }
    
    public void processMessage(String message, String recipient) {
        messageService.sendMessage(message, recipient);
    }
}
