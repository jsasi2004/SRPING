package com.banglore.App.CONFIG_BEAN;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public BeanExample getBeanExample(){
        return new BeanExample();
    }
}
