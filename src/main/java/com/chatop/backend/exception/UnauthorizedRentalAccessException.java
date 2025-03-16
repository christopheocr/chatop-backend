package com.chatop.backend.exception;

public class UnauthorizedRentalAccessException extends RuntimeException{
    public UnauthorizedRentalAccessException(String message) {
        super(message);
    }
}
