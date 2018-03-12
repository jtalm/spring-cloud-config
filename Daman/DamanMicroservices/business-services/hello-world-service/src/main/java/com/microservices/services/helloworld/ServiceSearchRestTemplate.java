package com.microservices.services.helloworld;

import com.microservices.services.configurations.ServiceSearcherConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * The type Service search rest template.
 */
@RestController
@RibbonClient(name = "service-searcher", configuration = ServiceSearcherConfiguration.class)
public class ServiceSearchRestTemplate {

    /**
     * Rest template.
     *
     * @return the rest template
     */
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * The Template.
     */
    @Autowired
    RestTemplate template;

    /**
     * Get searcher id.
     *
     * @return the string
     */
    @RequestMapping("/getSearcherId")
    public String getSearcherId() {
        return this.template.getForObject("http://service-searcher/getId", String.class);
    }

    /**
     * Gets service instances.
     *
     * @param name the name
     * @return the service instances
     */
    @RequestMapping("/getServiceInstances")
    public String getServiceInstances(
            @RequestParam(value = "name", defaultValue = "hello-world")
                    String name) {
        String greeting = this.template.getForObject("http://service-searcher/service-instances/" + name, String.class);
        return greeting;
    }

}
