package com.devyani.userSampleApi.exceptions;

public class ViolationErrorResponse {
    private final String fieldName;

    private final String message;

    public ViolationErrorResponse(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
