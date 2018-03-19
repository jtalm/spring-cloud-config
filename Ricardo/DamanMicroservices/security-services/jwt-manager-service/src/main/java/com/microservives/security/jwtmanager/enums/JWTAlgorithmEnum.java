package com.microservives.security.jwtmanager.enums;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The enums Jwt algorithm enums.
 */
public enum JWTAlgorithmEnum {

    HMAC512("HMAC512"),
    HMAC256("HMAC256");

    private static final Map<String, JWTAlgorithmEnum> ALGORITM_BY_ID = new ConcurrentHashMap<>(5);

    static {
        for (JWTAlgorithmEnum jwtAlgorithmEnum : JWTAlgorithmEnum.values()) {
            ALGORITM_BY_ID.put(jwtAlgorithmEnum.getAlgorithmID(), jwtAlgorithmEnum);
        }
    }

    private String algorithmID;

    JWTAlgorithmEnum(String algorithmID) {
        this.algorithmID = algorithmID;
    }

    public static Optional<JWTAlgorithmEnum> getAlgorithmByAlgorithmID(String algorithmID) {
        return ALGORITM_BY_ID.containsKey(algorithmID) ? Optional.of(ALGORITM_BY_ID.get(algorithmID)) : Optional.empty();
    }

    private String getAlgorithmID() {
        return this.algorithmID;
    }

}




