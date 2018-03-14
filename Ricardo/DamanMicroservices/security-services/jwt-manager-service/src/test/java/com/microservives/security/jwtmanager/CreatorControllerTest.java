package com.microservives.security.jwtmanager;

import com.microservives.security.jwtmanager.commons.TokenService;
import com.microservives.security.jwtmanager.controllers.CreatorController;
import com.microservives.security.jwtmanager.controllers.InfoController;
import com.microservives.security.jwtmanager.controllers.ValidatorController;
import com.microservives.security.jwtmanager.exceptions.JWTManagerException;
import mockit.Mock;
import mockit.MockUp;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.Assert.assertEquals;

/**
 * The type JWT controller test.
 */
@RunWith(JMockit.class)
public class CreatorControllerTest {

    /**
     * New token success.
     */
    @Test
    public void newTokenSuccess() {

        CreatorController creatorController = new CreatorController();
        MockHttpServletResponse response = new MockHttpServletResponse();
        String payload = "{\"sub\":\"ricardojmf\",\"itm\":\"900000\"}";

        creatorController.newToken(payload, response);

        assertEquals(response.getStatus(), 201);
    }

    /**
     * New token error.
     */
    @Test
    public void newTokenInvalid() {
        CreatorController creatorController = new CreatorController();
        MockHttpServletResponse response = new MockHttpServletResponse();
        String payload = "\"sub\":\"ricardojmf\",\"itm\":\"900000\"}";

        creatorController.newToken(payload, response);

        assertEquals(response.getStatus(), 403);
    }

    /**
     * New token error.
     */
    @Test
    public void newTokenError() {
        CreatorController creatorController = new CreatorController();
        MockHttpServletResponse response = new MockHttpServletResponse();
        String payload = "{\"sub\":\"ricardojmf\",\"itm\":\"900000\"}";

        new MockUp<TokenService>() {
            @Mock
            public String createToken(String payload) throws JWTManagerException {
                throw new JWTManagerException("newToken Intenal Error!");
            }
        };

        creatorController.newToken(payload, response);
        assertEquals(response.getStatus(), 500);
    }

    /**
     * Gets info success.
     */
    @Test
    public void getInfoSuccess() {
        CreatorController creatorController = new CreatorController();
        InfoController infoController = new InfoController();
        MockHttpServletResponse response = new MockHttpServletResponse();
        String payload = "{\"sub\":\"ricardojmf\",\"itm\":\"900000\"}";

        creatorController.newToken(payload, response);

        String token = response.getHeader("Authorization");

        infoController.getPayload(token, response);

        assertEquals(response.getStatus(), 200);
    }

    /**
     * Gets info invalid.
     */
    @Test
    public void getInfoInvalid() {
        CreatorController creatorController = new CreatorController();
        InfoController infoController = new InfoController();
        MockHttpServletResponse response = new MockHttpServletResponse();
        String payload = "{\"sub\":\"ricardojmf\",\"itm\":\"900000\"}";

        creatorController.newToken(payload, response);

        String token = response.getHeader("Authorization");

        String invalidToken = token + "ERRORCHARS";

        infoController.getPayload(invalidToken, response);

        assertEquals(response.getStatus(), 403);
    }

    /**
     * Gets info error.
     */
    @Test
    public void getInfoError() {
        CreatorController creatorController = new CreatorController();
        InfoController infoController = new InfoController();
        MockHttpServletResponse response = new MockHttpServletResponse();
        String payload = "{\"sub\":\"ricardojmf\",\"itm\":\"900000\"}";

        new MockUp<TokenService>() {
            @Mock
            public String getTokenInfo(String token) throws JWTManagerException {
                throw new JWTManagerException("getInfo Internal Error!");
            }
        };

        creatorController.newToken(payload, response);

        String token = response.getHeader("Authorization");

        infoController.getPayload(token, response);

        assertEquals(response.getStatus(), 500);
    }

    /**
     * Is valid.
     */
    @Test
    public void isValidSuccess() {
        CreatorController creatorController = new CreatorController();
        ValidatorController validatorController = new ValidatorController();
        MockHttpServletResponse response = new MockHttpServletResponse();
        String payload = "{\"sub\":\"ricardojmf\",\"itm\":\"900000\"}";

        creatorController.newToken(payload, response);

        String token = response.getHeader("Authorization");

        validatorController.isValid(token, response);

        assertEquals(response.getStatus(), 204);
    }

    /**
     * Is valid invalid.
     */
    @Test
    public void isValidInvalid() {
        CreatorController creatorController = new CreatorController();
        ValidatorController validatorController = new ValidatorController();
        MockHttpServletResponse response = new MockHttpServletResponse();
        String payload = "{\"sub\":\"ricardojmf\",\"itm\":\"900000\"}";

        creatorController.newToken(payload, response);

        String token = response.getHeader("Authorization");

        String invalidToken = token + "ERRORCHARS";

        validatorController.isValid(invalidToken, response);

        assertEquals(response.getStatus(), 403);
    }

    /**
     * Is valid error.
     */
    @Test
    public void isValidError() {
        CreatorController creatorController = new CreatorController();
        ValidatorController validatorController = new ValidatorController();
        MockHttpServletResponse response = new MockHttpServletResponse();
        String payload = "{\"sub\":\"ricardojmf\",\"itm\":\"900000\"}";

        new MockUp<TokenService>() {
            @Mock
            public void isTokenValid(String token) throws JWTManagerException {
                throw new JWTManagerException("isValid Internal Error");
            }
        };

        creatorController.newToken(payload, response);

        String token = response.getHeader("Authorization");

        validatorController.isValid(token, response);

        assertEquals(response.getStatus(), 500);
    }

}