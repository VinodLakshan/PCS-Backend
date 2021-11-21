package com.esoft.pcs.dto;

import org.springframework.http.HttpStatus;

public class ErrorResponseDto {

    private HttpStatus status;
    private String message;

    public ErrorResponseDto(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

}
