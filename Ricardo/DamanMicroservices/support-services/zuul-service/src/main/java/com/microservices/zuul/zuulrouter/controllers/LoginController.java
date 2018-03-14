package com.microservices.zuul.zuulrouter.controllers;

import com.microservices.zuul.zuulrouter.configurations.JWTManagerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

@RestController
@RibbonClient(name="JWTManager-Service", configuration = JWTManagerConfiguration.class)
public class LoginController {

    /**
     * Rest restTemplate.
     *
     * @return the rest restTemplate
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

    @RequestMapping("/blele")
    public void getCenas(HttpServletRequest request, HttpServletResponse response){

        String payload = "{\"sub\":\"ricardojmf\",\"itm\":\"900000\"}";

        System.out.println(this.template);
        this.template.getForObject("http://JWTManager-Service/new/token", request, response, Void.class);


    }

}
