package com.basiony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * this annotation includes implicitly the following:
 *
 * @SpringBootConfiguration.
 * @EnableAutoConfiguration.
 * @ComponantScan.
 */
@EnableJpaRepositories(basePackages = "com.basiony")
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
