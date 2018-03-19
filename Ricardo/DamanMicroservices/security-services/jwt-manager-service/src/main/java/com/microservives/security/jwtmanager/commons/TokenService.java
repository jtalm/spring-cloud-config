package com.microservives.security.jwtmanager.commons;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservives.security.jwtmanager.enums.JWTAlgorithmEnum;
import com.microservives.security.jwtmanager.exceptions.JWTInvalidRequestException;
import com.microservives.security.jwtmanager.exceptions.JWTManagerException;
import org.apache.commons.codec.binary.Base64;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

/**
 * The type Token service.
 */
public class TokenService {

    //TODO: PUT THIS INFORMATION IN CONFIG
    private static final String SECRET = "secret";

    private static final String ISSUER = "Daman";

    private static final String SCHEMA = "Bearer";

    private static final String ALGORITHM_NAME = "HMAC512";

    private static final long EXPIRATION = 60000 * 20;

    /**
     * TokenService Constructor
     */
    private TokenService() {
        //Empty Contructor
    }

    /**
     * Create token.
     *
     * @param payload the payload
     * @return the string
     * @throws JWTManagerException the jWT manager exception
     * @throws JWTManagerException the jWT manager exception
     */
    @NotNull
    public static String createToken(String payload) throws JWTManagerException, JWTInvalidRequestException {

        Algorithm algorithm;
        try {
            algorithm = getAlgorithm(ALGORITHM_NAME);
        } catch (UnsupportedEncodingException exception) {
            throw new JWTManagerException("Algorithm & Secret Encoding Error!", exception);
        }

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> payloadMap;

        try {
            payloadMap = mapper.readValue(payload, new TypeReference<Map<String, String>>() {
            });
        } catch (IOException e) {
            throw new JWTInvalidRequestException("JSON to Map mapping Error!", e);
        }

        JWTCreator.Builder tokenBuild = JWT.create()
                .withIssuer(ISSUER)
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION));

        payloadMap.forEach((k, v) -> tokenBuild.withClaim(k, v.toString()));

        return SCHEMA + ' ' + tokenBuild.sign(algorithm);
    }

    /**
     * Is token valid.
     *
     * @param token the token
     * @throws JWTManagerException the jWT manager exception
     * @throws JWTManagerException the jWT manager exception
     */
    public static void isTokenValid(String token) throws JWTManagerException, JWTInvalidRequestException {

        Algorithm algorithm;
        try {
            algorithm = getAlgorithm(ALGORITHM_NAME);
        } catch (UnsupportedEncodingException exception) {
            throw new JWTManagerException("Algorithm & Secret Encoding Error!", exception);
        }

        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(ISSUER)
                .build();

        //TODO Explain library good practices constraints
        try {
            DecodedJWT decodedJWT = verifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new JWTInvalidRequestException("Token Validation Error Exception", e);
        }
    }

    /**
     * Gets token info.
     *
     * @param token the token
     * @return the token info
     * @throws JWTManagerException the jWT manager exception
     * @throws JWTManagerException the jWT manager exception
     */
    @NotNull
    public static String getTokenInfo(String token) throws JWTManagerException, JWTInvalidRequestException {

        isTokenValid(token);

        try {
            DecodedJWT decodedToken = JWT.decode(token);
            return new String(Base64.decodeBase64(decodedToken.getPayload().getBytes()));
        } catch (JWTDecodeException e) {
            throw new JWTManagerException("Token Decoding Error Exception", e);
        }
    }

    /**
     * Gets token from header.
     *
     * @param token the token
     * @return token from header
     * @throws JWTInvalidRequestException the jWT invalid request exception
     */
    public static String getTokenFromHeader(@NotNull String token) throws JWTInvalidRequestException {

        String[] splitedToken = token.split("\\s+");

        if (splitedToken.length != 2) {
            throw new JWTInvalidRequestException("Invalid Header Token");
        }

        if (!splitedToken[0].matches(SCHEMA)) {
            throw new JWTInvalidRequestException("Invalid Header Token");
        }

        return splitedToken[1];
    }

    /**
     * Gets the algorithm with a string
     */
    private static Algorithm getAlgorithm(String algorithmID) throws JWTManagerException, UnsupportedEncodingException {
        Optional<JWTAlgorithmEnum> algorithmEnumOptional = JWTAlgorithmEnum.getAlgorithmByAlgorithmID(algorithmID);

        if (!algorithmEnumOptional.isPresent()) {
            //todo: set a better message
            throw new JWTManagerException("Algorithm Configuration Error!");
        }

        JWTAlgorithmEnum algorithmEnum = algorithmEnumOptional.get();
        Algorithm algorithm;
        switch (algorithmEnum) {
            case HMAC512:
                algorithm = Algorithm.HMAC512(SECRET);
                break;
            case HMAC256:
                algorithm = Algorithm.HMAC256(SECRET);
                break;
            default:
                throw new JWTManagerException("Algorithm Configuration Error!");
        }
        return algorithm;
    }
}



