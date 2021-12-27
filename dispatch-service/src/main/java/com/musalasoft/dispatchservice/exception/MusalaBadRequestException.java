package com.musalasoft.dispatchservice.exception;

import lombok.Getter;

public class MusalaBadRequestException extends RuntimeException {
    @Getter
    private String code;

    public MusalaBadRequestException(String message, String code) {
        super(message);
        this.code = code;
    }
}
