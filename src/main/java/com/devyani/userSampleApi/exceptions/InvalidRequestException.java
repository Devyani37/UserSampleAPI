package com.devyani.userSampleApi.exceptions;

public class InvalidRequestException extends  RuntimeException{
    public InvalidRequestException(String msg){
        super(msg);
    }

    public InvalidRequestException(String msg, Throwable t){
        super(msg,t);
    }

}