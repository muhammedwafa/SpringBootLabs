package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo2Application {

    public static void main(String[] args) {
        // to run a spring boot app 
        SpringApplication.run(Demo2Application.class, args);
        // don't use sout command here 
        // create a rest controller to call from browser 
        // just for demonstration  
//         System.out.println("Hellooooooo");
    }


}
