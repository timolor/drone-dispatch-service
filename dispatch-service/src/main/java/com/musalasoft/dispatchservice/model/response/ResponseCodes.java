package com.musalasoft.dispatchservice.model.response;

import lombok.Getter;

@Getter
public enum ResponseCodes {
    SUCCESS("00", "Successful"),
    BAD_REQUEST("10400", "Bad Request"),
    SYSYEM_ERROR("10500", "Something went wrong. Please try again later");

    private String code;
    private String message;

    ResponseCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
