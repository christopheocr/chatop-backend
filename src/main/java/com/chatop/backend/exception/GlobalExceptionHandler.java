package com.chatop.backend.exception;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private static final Map<Class<? extends Exception>, HttpStatus> EXCEPTION_STATUS_MAP = new HashMap<>();

    static {
        EXCEPTION_STATUS_MAP.put(BadCredentialsException.class, HttpStatus.UNAUTHORIZED);
        EXCEPTION_STATUS_MAP.put(AccountStatusException.class, HttpStatus.FORBIDDEN);
        EXCEPTION_STATUS_MAP.put(AccessDeniedException.class, HttpStatus.FORBIDDEN);
        EXCEPTION_STATUS_MAP.put(SignatureException.class, HttpStatus.FORBIDDEN);
        EXCEPTION_STATUS_MAP.put(ExpiredJwtException.class, HttpStatus.FORBIDDEN);
        EXCEPTION_STATUS_MAP.put(IOException.class, HttpStatus.INTERNAL_SERVER_ERROR);
        EXCEPTION_STATUS_MAP.put(FileNotFoundException.class, HttpStatus.NOT_FOUND);
        EXCEPTION_STATUS_MAP.put(UserRegistrationException.class, HttpStatus.INTERNAL_SERVER_ERROR);
        EXCEPTION_STATUS_MAP.put(UserNotFoundException.class, HttpStatus.NOT_FOUND);
        EXCEPTION_STATUS_MAP.put(RentalNotFoundException.class, HttpStatus.NOT_FOUND);
        EXCEPTION_STATUS_MAP.put(UnauthorizedRentalAccessException.class, HttpStatus.FORBIDDEN);
        EXCEPTION_STATUS_MAP.put(FileStorageException.class, HttpStatus.INTERNAL_SERVER_ERROR);



    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException(Exception exception) {
        HttpStatus status = EXCEPTION_STATUS_MAP.getOrDefault(exception.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);

        ProblemDetail errorDetail = ProblemDetail.forStatusAndDetail(status, exception.getMessage());
        errorDetail.setProperty("description", getErrorDescription(exception));

        logger.error("Exception handled: {}, Status: {}, Message: {}", exception.getClass().getSimpleName(), status, exception.getMessage());

        return errorDetail;
    }

    private String getErrorDescription(Exception exception) {
        if (exception instanceof UnauthorizedRentalAccessException) {
            return "You do not have permission to modify this rental";
        }
        if (exception instanceof FileStorageException) {
            return "An error occurred while uploading the file";
        }
        if (exception instanceof UserNotFoundException) {
            return "The specified user was not found";
        }
        if (exception instanceof RentalNotFoundException) {
            return "The specified rental was not found";
        }
        if (exception instanceof UserRegistrationException) {
            return "User could not be registered due to an internal error";
        }
        if (exception instanceof BadCredentialsException) {
            return "The username or password is incorrect";
        }
        if (exception instanceof AccountStatusException) {
            return "The account is locked";
        }
        if (exception instanceof AccessDeniedException) {
            return "You are not authorized to access this resource";
        }
        if (exception instanceof SignatureException) {
            return "The JWT signature is invalid";
        }
        if (exception instanceof ExpiredJwtException) {
            return "The JWT token has expired";
        }
        if (exception instanceof FileNotFoundException) {
            return "The requested file does not exist";
        }
        if (exception instanceof IOException) {
            return "File upload failed due to an internal error";
        }

        return "Unknown internal server error.";
    }
}
