package com.banglore.App.service;

import org.springframework.stereotype.Service;

@Service
public class helloService{
    public String getGreeting() {
        return "Hello from HelloService!";
    }
}
