package com.microservives.security.jwtmanager.controllers;

import com.microservives.security.jwtmanager.commons.LoggingUtils;
import com.microservives.security.jwtmanager.commons.TokenService;
import com.microservives.security.jwtmanager.exceptions.JWTInvalidRequestException;
import com.microservives.security.jwtmanager.exceptions.JWTManagerException;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * The type JWT controller.
 */
@RestController
public class ValidatorController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ValidatorController.class);

    /**
     * Is valid.
     *
     * @param bearerToken the token
     * @param response the response
     */
    @RequestMapping(value = "/token/validate", method = RequestMethod.GET)
    public void isValid(
            @RequestHeader("Authorization")
                    String bearerToken, HttpServletResponse response) {
        try {
            String token = TokenService.getTokenFromHeader(bearerToken);
            TokenService.isTokenValid(token);
            response.setStatus(204);
            LOGGER.info(LoggingUtils.getStatusLogMessage(response.getStatus(), "Valid Token!"));
        } catch (JWTManagerException exception) {
            response.setStatus(500);
            LOGGER.error(LoggingUtils.getStatusLogMessage(response.getStatus(), exception.getMessage()));
        } catch (JWTInvalidRequestException exception) {
            response.setStatus(403);
            LOGGER.error(LoggingUtils.getStatusLogMessage(response.getStatus(), exception.getMessage()));
        }
    }

    @RequestMapping("/por_favor_funciona")
    public String porFavorFunciona(){
        return "FUNCIONOU!!";
    }
}
