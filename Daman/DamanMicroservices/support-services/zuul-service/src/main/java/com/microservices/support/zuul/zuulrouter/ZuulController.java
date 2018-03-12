package com.microservices.support.zuul.zuulrouter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZuulController {

    @RequestMapping("/authenticate")
    public String authenticate(){
        return "Authenticated";
    }

}
