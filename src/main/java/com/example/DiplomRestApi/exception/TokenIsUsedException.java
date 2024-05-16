package com.example.DiplomRestApi.exception;

public class TokenIsUsedException extends RuntimeException {

    public TokenIsUsedException(String message) {
        super(message);
    }
}

