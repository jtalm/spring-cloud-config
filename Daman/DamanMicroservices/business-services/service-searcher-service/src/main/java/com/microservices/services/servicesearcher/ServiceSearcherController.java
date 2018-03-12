package com.microservices.services.servicesearcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * The type Service searcher controller.
 */

@EnableDiscoveryClient
@RestController
public class ServiceSearcherController {

    /**
     * The Discovery client.
     */
    @Autowired
    public DiscoveryClient discoveryClient;

    private UUID serviceSearcherID;

    {
        this.serviceSearcherID = UUID.randomUUID();
    }

    /**
     * Service instances by application name.
     *
     * @param applicationName the application name
     * @return the list
     */
    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable
                    String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    /**
     * Gets uUID.
     *
     * @return the uUID
     */
    @RequestMapping("/getId")
    public String getUUID() {
        return serviceSearcherID.toString();
    }
}
