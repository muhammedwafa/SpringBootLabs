package com.example.outSideService;

import com.example.demo5.service.MyService;
import org.springframework.stereotype.Service;

//@Service
public class OutSideService implements MyService {
    @Override
    public String sayHello(){
        return "Hello from an outside  service";
    }
}