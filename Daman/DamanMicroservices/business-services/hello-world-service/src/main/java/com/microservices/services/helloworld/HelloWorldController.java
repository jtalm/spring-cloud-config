package com.microservices.services.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * The type Hello world controller.
 */
@RefreshScope
@RestController
public class HelloWorldController {

    /**
     * This service's unique ID
     */
    private UUID helloWorldID;

    {
        this.helloWorldID = UUID.randomUUID();
    }

    /**
     * The Greeting world.
     */
    @Value("${greeting.world:Hello default}")
    public String greetingWorld;

    /**
     * Home string.
     *
     * @return the string
     */
    @CrossOrigin
    @RequestMapping("/")
    public String home() {
        return "[" + helloWorldID + "] " + greetingWorld;
    }

    /**
     * Post my name.
     *
     * @param name the name
     * @return the string
     */
    @RequestMapping(value = "/myname", method = RequestMethod.POST)
    public String postMyName(String name) {
        return "[" + helloWorldID + "] My post name is " + name;
    }

    /**
     * Gets my name.
     *
     * @param name the name
     * @return the my name
     */
    @RequestMapping(value = "/myname", method = RequestMethod.GET)
    public String getMyName(String name) {
        return "[" + helloWorldID + "] My get name is " + name;
    }

}
