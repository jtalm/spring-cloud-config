package com.microservices.zuul.zuulrouter.controllers;

/**
 * The type Account credentials.
 */
public class AccountCredentials {

    private String username;
    private String password;

    /**
     * Instantiates a new Account credentials.
     *
     * @param username the username
     * @param password the password
     */
    public AccountCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
