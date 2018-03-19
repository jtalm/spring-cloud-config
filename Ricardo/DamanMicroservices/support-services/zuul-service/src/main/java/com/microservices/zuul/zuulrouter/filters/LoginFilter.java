package com.microservices.zuul.zuulrouter.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.zuul.zuulrouter.controllers.AccountCredentials;
import com.microservices.zuul.zuulrouter.controllers.LoginController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * The type Jwt login filter.
 */
public class LoginFilter extends AbstractAuthenticationProcessingFilter {

    /**
     * Instantiates a new Jwt login filter.
     *
     * @param url the url
     * @param authenticationManager the authentication manager
     */
    public LoginFilter(String url, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws AuthenticationException, IOException, ServletException {

        AccountCredentials credentials = new ObjectMapper().readValue(httpServletRequest.getInputStream(), AccountCredentials.class);

        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        credentials.getUsername(),
                        credentials.getPassword(),
                        Collections.<GrantedAuthority>emptyList()
                )
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        System.out.println("cenas");
//        LoginController l = new LoginController();
//        l.getCenas(request, response);
//        System.out.println(response.getHeader("Authentication"));
    }
}
