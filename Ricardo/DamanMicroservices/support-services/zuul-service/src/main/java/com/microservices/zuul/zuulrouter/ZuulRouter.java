package com.microservices.zuul.zuulrouter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * The type Zuul router.
 */
@EnableZuulProxy
@SpringBootApplication
@EnableEurekaClient
public class ZuulRouter {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ZuulRouter.class, args);
    }

}
