package com.example.calculateservice.exceptions;

public class InvalidJwtTokenException extends RuntimeException {
    public InvalidJwtTokenException() {
    }

    public InvalidJwtTokenException(String message) {
        super(message);
    }

    public InvalidJwtTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
