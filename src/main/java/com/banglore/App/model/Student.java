package com.banglore.App.model;

import org.springframework.stereotype.Component;


@Component
public class Student {
    public Student(){
        System.out.println("hi");
    }
    int id;
    String name;
    public String sayHello() {
        return "Hello from MyComponent!";
    }
}
