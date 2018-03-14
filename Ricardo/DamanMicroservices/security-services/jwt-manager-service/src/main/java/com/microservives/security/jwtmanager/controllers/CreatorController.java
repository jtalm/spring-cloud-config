package com.microservives.security.jwtmanager.controllers;

import com.microservives.security.jwtmanager.commons.LoggingUtils;
import com.microservives.security.jwtmanager.commons.TokenService;
import com.microservives.security.jwtmanager.exceptions.JWTInvalidRequestException;
import com.microservives.security.jwtmanager.exceptions.JWTManagerException;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * The type JWT controller.
 */
@RestController
public class CreatorController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CreatorController.class);

    /**
     * New token.
     *
     * @param payload the payload
     * @param response the response
     */
    @RequestMapping("/token/new")
    public void newToken(
            @RequestHeader("payload")
                    String payload, HttpServletResponse response) {
        try {
            response.addHeader("Authorization", TokenService.createToken(payload));
            response.setStatus(201);
            LOGGER.info(LoggingUtils.getStatusLogMessage(response.getStatus(), "Token successfully created!"));
        } catch (JWTManagerException exception) {
            response.setStatus(500);
            LOGGER.error(LoggingUtils.getStatusLogMessage(response.getStatus(), exception.getMessage()));
        } catch (JWTInvalidRequestException exception) {
            response.setStatus(403);
            LOGGER.error(LoggingUtils.getStatusLogMessage(response.getStatus(), exception.getMessage()));
        }
    }
}
