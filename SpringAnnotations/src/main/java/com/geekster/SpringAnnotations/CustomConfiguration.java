package com.geekster.SpringAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfiguration {
    @Bean
    public Student getStudent() {
        System.out.println("Spring call in config bean of student");
        return new Student("Divya");
    }
}
