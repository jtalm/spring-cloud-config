package com.microservices.business.helloworld.configurations;

import com.netflix.client.config.IClientConfig;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The type Service searcher configuration.
 */
public class ServiceSearcherConfiguration {

    /**
     * The Ribbon client config.
     */
    @Autowired
    IClientConfig ribbonClientConfig;
}
