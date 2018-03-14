package com.microservives.security.jwtmanager.commons;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * The type Logging utils.
 */
public class LoggingUtils {

    private LoggingUtils() {
        //Empty Constructor
    }

    /**
     * Gets status log message.
     *
     * @param status the status
     * @param message the message
     * @return the status log message
     */

    @NotNull
    @Contract(pure = true)
    public static String getStatusLogMessage(int status, String message) {
        return "LOG: " + '[' + status + ']' + " - " + message;
    }

}