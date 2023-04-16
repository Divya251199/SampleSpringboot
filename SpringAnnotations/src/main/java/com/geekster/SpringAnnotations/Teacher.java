package com.geekster.SpringAnnotations;


import org.springframework.stereotype.Component;

@Component
public class Teacher
{
    public String teach() {
        return "He is teaching Spring boot";
    }
}
