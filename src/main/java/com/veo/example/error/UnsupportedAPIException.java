package com.veo.example.error;


public class UnsupportedAPIException extends RuntimeException {

    public UnsupportedAPIException(String message) {
        super(message);
    }
}
