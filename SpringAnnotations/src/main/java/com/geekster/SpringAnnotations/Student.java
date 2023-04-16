package com.geekster.SpringAnnotations;

import org.springframework.stereotype.Component;

public class Student {

    private  String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
        System.out.println("Student called from Spring framework-1");
    }
    public Student(String name ) {
        System.out.println("Student called from Spring framework-2");
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        return sb.toString();
    }

}
