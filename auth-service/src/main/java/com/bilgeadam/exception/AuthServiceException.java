package com.bilgeadam.exception;

import lombok.Getter;
import com.bilgeadam.exception.ErrorType;

@Getter
public class AuthServiceException extends RuntimeException{
    private static final long serialVersionUID = -8738909838642675933L;

    private final ErrorType errorType;

    public AuthServiceException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public AuthServiceException(String message, ErrorType errorType) {
        super(message);
        this.errorType = errorType;
    }
}
