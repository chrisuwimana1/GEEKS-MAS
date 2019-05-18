package com.mum.edu.geek.controller;

import com.mum.edu.geek.dto.ErrorDTO;
import com.mum.edu.geek.dto.ResultDTO;
import com.mum.edu.geek.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO generalHandle(Exception ex){
        return new ErrorDTO("",ex.getMessage());
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResultDTO generalHandle(BusinessException ex){
        System.out.println("aa");
        return new ResultDTO(ex.getMessage(),false);
    }



}

