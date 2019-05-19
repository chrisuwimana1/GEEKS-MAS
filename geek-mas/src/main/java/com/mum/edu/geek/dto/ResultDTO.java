package com.mum.edu.geek.dto;

public class ResultDTO {

    private String message;
    private boolean ok;

    public ResultDTO(String message,boolean ok){
        this.setMessage(message);
        this.setOk(ok);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
}
