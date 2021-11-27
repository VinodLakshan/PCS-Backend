package com.esoft.pcs.dto;

import org.springframework.http.HttpStatus;

public class ResponseDto {

    private Object data;
    private HttpStatus status;
    private String token;

    public ResponseDto(Object data, HttpStatus status, String token) {
        this.data = data;
        this.status = status;
        this.token = token;
    }

    public ResponseDto(Object data, HttpStatus status) {
        this.data = data;
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
