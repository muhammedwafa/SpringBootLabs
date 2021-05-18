package com.example.demo5.service;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {
    @Override
    public String sayHello(){
        return "Hello from my service";
    }
}
