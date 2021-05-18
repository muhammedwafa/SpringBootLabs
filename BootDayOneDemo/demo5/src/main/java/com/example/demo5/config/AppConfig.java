package com.example.demo5.config;


import com.example.outSideService.Config;
import jdk.jfr.Enabled;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@ComponentScan("com.example.outSideService")
@Import(Config.class)
//@ImportResource("classpath:")
//@EnableAutoConfiguration(exclude ={DataSourceAutoConfiguration.class})
public class AppConfig {
}
