package com.dt.copeland.exception;

public class LoginException extends RuntimeException{
    private String message;

    public LoginException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
