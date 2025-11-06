package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.config.AppConfig;
import com.example.consumer.MessageClient;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        MessageClient client = context.getBean(MessageClient.class);
        client.processMessage("Hello from Spring DI!", "user@example.com");
        
        ((AnnotationConfigApplicationContext) context).close();
    }
}
