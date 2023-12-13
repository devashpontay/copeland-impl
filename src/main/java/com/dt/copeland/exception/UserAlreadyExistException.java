package com.dt.copeland.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public UserAlreadyExistException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
