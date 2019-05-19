package com.mum.edu.geek.controller;

import com.mum.edu.geek.dto.ErrorDTO;
import com.mum.edu.geek.dto.ResultDTO;
import com.mum.edu.geek.exception.BusinessException;
import com.mum.edu.geek.exception.GeneralException;
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
    public ErrorDTO errorHandle(Exception ex){
        return new ErrorDTO(ex.getMessage(),ex.getMessage());
    }


    @ExceptionHandler({GeneralException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO generalHandle(GeneralException ex){
        return new ErrorDTO(ex.getCustomMessage(),ex.getMessage());
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResultDTO businessHandle(BusinessException ex){
        System.out.println("aa");
        return new ResultDTO(ex.getMessage(),false);
    }



}