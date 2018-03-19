package com.microservices.zuul.zuulrouter.configurations;

import com.netflix.client.config.IClientConfig;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The type Jwt manager configuration.
 */

public class JWTManagerConfiguration {

    @Autowired
    IClientConfig ribbonClientConfig;

}
