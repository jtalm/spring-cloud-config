package com.microservives.security.jwtmanager.controllers;

import com.microservives.security.jwtmanager.commons.LoggingUtils;
import com.microservives.security.jwtmanager.commons.TokenService;
import com.microservives.security.jwtmanager.exceptions.JWTInvalidRequestException;
import com.microservives.security.jwtmanager.exceptions.JWTManagerException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * The type JWT controller.
 */
@RestController
public class InfoController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(InfoController.class);

    /**
     * Gets info.
     *
     * @param bearerToken the token
     * @param response the response
     * @return the info
     */
    @RequestMapping("token/payload")
    public String getPayload(
            @RequestHeader("Authorization")
                    String bearerToken, HttpServletResponse response) {

        try {
            String token = TokenService.getTokenFromHeader(bearerToken);
            response.setStatus(200);
            LOGGER.info(LoggingUtils.getStatusLogMessage(response.getStatus(), "Information retrieved successfully!"));
            return TokenService.getTokenInfo(token);
        } catch (JWTManagerException exception) {
            response.setStatus(500);
            LOGGER.error(LoggingUtils.getStatusLogMessage(response.getStatus(), exception.getMessage()));
        } catch (JWTInvalidRequestException exception) {
            response.setStatus(403);
            LOGGER.error(LoggingUtils.getStatusLogMessage(response.getStatus(), exception.getMessage()));
        }

        return StringUtils.EMPTY;
    }
}
