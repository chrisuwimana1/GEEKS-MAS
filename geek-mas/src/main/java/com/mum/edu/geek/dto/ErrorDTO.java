package com.mum.edu.geek.dto;

public class ErrorDTO{

    private String userMessage;
    private String errorMessage;

    public ErrorDTO(String userMessage,String errorMessage){
        this.setUserMessage(userMessage);
        this.setErrorMessage(errorMessage);
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
}