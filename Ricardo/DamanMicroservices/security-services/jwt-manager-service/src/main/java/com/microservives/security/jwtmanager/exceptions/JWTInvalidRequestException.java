package com.microservives.security.jwtmanager.exceptions;

/**
 * The type JWT invalid token exception.
 */
public class JWTInvalidRequestException extends Exception {

    private static final long serialVersionUID = 1305482602577662258L;

    /**
     * Instantiates a new JWT invalid request exception.
     */
    public JWTInvalidRequestException() {}

    /**
     * Instantiates a new JWT invalid token exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public JWTInvalidRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new JWT invalid token exception.
     *
     * @param message the message
     */
    public JWTInvalidRequestException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
