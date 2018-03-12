package com.microservices.business.servicesearcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * The type Service searcher.
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = { "com.microservices.business.servicesearcher" })
public class ServiceSearcher {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ServiceSearcher.class, args);
    }

}
