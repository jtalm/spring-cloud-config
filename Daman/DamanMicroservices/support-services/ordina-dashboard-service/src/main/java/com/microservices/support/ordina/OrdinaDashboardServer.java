package com.microservices.support.ordina;

import be.ordina.msdashboard.EnableMicroservicesDashboardServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The type Ordina dashboard server.
 */
@EnableDiscoveryClient
@EnableMicroservicesDashboardServer
@SpringBootApplication
public class OrdinaDashboardServer {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(OrdinaDashboardServer.class, args);
    }
}
