package com.devyani.userSampleApi.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class UserControllerExceptionsHandler extends ResponseEntityExceptionHandler {

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

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ViolationErrorResponse> violationErrorResponses = new ArrayList<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            ViolationErrorResponse errorResponse = new ViolationErrorResponse(fieldError.getField(), fieldError.getDefaultMessage());
            violationErrorResponses.add(errorResponse);
        }
        return new ResponseEntity<>(violationErrorResponses, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<ViolationErrorResponse>> constraintViolationErrorResponse(ConstraintViolationException ex, WebRequest request){
        List<ViolationErrorResponse> violationErrorResponses = new ArrayList<>();
        for(ConstraintViolation violation : ex.getConstraintViolations()){
            ViolationErrorResponse errorResponse = new ViolationErrorResponse(violation.getPropertyPath().toString(), violation.getMessage());
            violationErrorResponses.add(errorResponse);

        }
        return new ResponseEntity<>(violationErrorResponses, HttpStatus.BAD_REQUEST);
    }

}
