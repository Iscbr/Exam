package com.project.exam.controllers;

public class RestResponse {
    private int codeStatus;
    private String message;

    public RestResponse(int codeStatus, String message) {
        this.codeStatus = codeStatus;
        this.message = message;
    }

    public int getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(int codeStatus) {
        this.codeStatus = codeStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}