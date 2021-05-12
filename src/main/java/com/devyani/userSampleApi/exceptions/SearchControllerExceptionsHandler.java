package com.devyani.userSampleApi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SearchControllerExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> genericHandler(Exception ex, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError(HttpStatus.INTERNAL_SERVER_ERROR.name());
        errorResponse.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> illegalArgumenttHandler(Exception ex, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError(HttpStatus.BAD_REQUEST.name());
        errorResponse.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ErrorResponse> invalidRequestExceptionHandler(Exception ex, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError(HttpStatus.NOT_FOUND.name());
        errorResponse.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
