package com.example.demo5.controller;

import com.example.demo5.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {



    private MyService service;

    @Autowired
    public MyController(@Qualifier("outSideService") MyService service){
        this.service = service;
    }
    @GetMapping("/")
    String sayHello(){
        return service.sayHello();
    }
}
