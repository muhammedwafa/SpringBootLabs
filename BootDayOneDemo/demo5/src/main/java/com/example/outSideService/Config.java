package com.example.outSideService;

import com.example.demo5.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
public MyService outSideService(){
        return new OutSideService();
    }
}
