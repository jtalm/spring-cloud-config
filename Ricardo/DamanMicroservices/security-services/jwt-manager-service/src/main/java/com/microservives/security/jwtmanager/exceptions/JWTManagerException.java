package com.microservives.security.jwtmanager.exceptions;

/**
 * The type JWT manager exception.
 */
public class JWTManagerException extends Exception {

    private static final long serialVersionUID = -7600985094398915677L;

    /**
     * Instantiates a new JWT manager exception.
     */
    public JWTManagerException() {
    }

    /**
     * Instantiates a new JWT manager exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public JWTManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new JWT manager exception.
     *
     * @param message the message
     */
    public JWTManagerException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
