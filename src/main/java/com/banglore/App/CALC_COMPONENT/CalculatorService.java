package com.banglore.App.CALC_COMPONENT;

import org.springframework.stereotype.Component;

@Component
public class CalculatorService {
    public int add(int a,int b){
        return a+b;
    }
    public boolean isEven(int a){
        return a%2==0;
    }
}
