package com.musalasoft.dispatchservice.exception;

import lombok.Getter;

public class MusalaResourceNotFoundException extends RuntimeException {
    @Getter
    private String code;

    public MusalaResourceNotFoundException(String message, String code){
        super(message);
        this.code = code;
    }
    
}
