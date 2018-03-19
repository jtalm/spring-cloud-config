package com.microservices.zuul.zuulrouter.filters;

import com.microservices.zuul.zuulrouter.controllers.LoginController;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Authentication filter.
 */

public class AuthenticationFilter extends GenericFilterBean {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //TODO CALL VERIFY TOKEN

        LoginController l = new LoginController();

        String payload = "{\"sub\":\"ricardojmf\",\"itm\":\"900000\"}";

        l.getCenas((HttpServletRequest) request, (HttpServletResponse) response);

        System.out.println(((HttpServletRequest)response).getHeader("Authorization"));

        //this.jwtRestTemplate().postForObject("http://jwtmanager-service/token/new", payload, String.class);



        //this.template.getForObject("http://service-searcher/service-instances/" + name, String.class);
        //System.out.println(((HttpServletRequest)request).getHeader("Authorization"));

    }
}
