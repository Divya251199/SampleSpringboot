package com.geekster.SpringAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandleMailConfiguration {
    @Bean
    public HandleMail getHandleMail( ) {
        return new HandleMail();
    }
}
