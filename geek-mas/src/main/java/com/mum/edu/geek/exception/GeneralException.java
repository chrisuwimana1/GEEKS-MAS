package com.mum.edu.geek.exception;

import javax.persistence.GeneratedValue;

public class GeneralException extends RuntimeException{

    private  String customMessage;

    public GeneralException(String message,String customMessage){
        super(message);
        this.customMessage = customMessage;
    }

    public String getCustomMessage() {
        return customMessage;
    }
}
