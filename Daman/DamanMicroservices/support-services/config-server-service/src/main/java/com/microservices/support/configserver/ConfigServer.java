package com.microservices.support.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * The type Config server.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer.class, args);
    }

}
