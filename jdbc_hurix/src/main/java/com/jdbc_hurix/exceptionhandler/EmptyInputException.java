package com.jdbc_hurix.exceptionhandler;

import lombok.Data;

@Data
public class EmptyInputException extends RuntimeException{
    private Integer errorCode;
    private String message;

    public EmptyInputException(Integer errorCode, String message){
        this.errorCode=errorCode;
        this.message=message;
    }
}
