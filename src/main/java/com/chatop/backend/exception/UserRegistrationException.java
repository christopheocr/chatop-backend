package com.chatop.backend.exception;

public class UserRegistrationException extends RuntimeException{
    public UserRegistrationException(String message) {
        super(message);
    }
}
