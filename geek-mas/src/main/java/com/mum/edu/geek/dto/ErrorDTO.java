package com.mum.edu.geek.dto;

import org.springframework.validation.FieldError;

import java.util.List;

public class ErrorDTO{

    private String errorType;
    private String userMessage;
    private String errorMessage;
    private List<String> validationMessages;

    public ErrorDTO(List<String> validationMessages){
        this.setErrorType(ErrorType.VALIDATION.toString());
        this.setValidationMessages(validationMessages);
    }

    public ErrorDTO(String userMessage,String errorMessage,ErrorType type){
        this.setUserMessage(userMessage);
        this.setErrorMessage(errorMessage);
        this.setErrorType(type.toString());
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }


    public List<String> getValidationMessages() {
        return validationMessages;
    }

    public void setValidationMessages(List<String> validationMessages) {
        this.validationMessages = validationMessages;
    }
}