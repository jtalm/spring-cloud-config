package com.microservices.services.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * The type Hello world.
 *
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = { "com.microservices.services.helloworld" })
public class HelloWorld {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(HelloWorld.class, args);
    }

}
