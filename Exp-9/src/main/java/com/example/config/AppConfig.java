package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.example.service.MessageService;
import com.example.service.EmailService;

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
    
    @Bean
    public MessageService messageService() {
        return new EmailService();
    }
}
