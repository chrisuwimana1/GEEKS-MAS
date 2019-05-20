package com.mum.edu.geek.controller;

import com.mum.edu.geek.dto.ErrorDTO;
import com.mum.edu.geek.dto.ErrorType;
import com.mum.edu.geek.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDTO anyExceptionHandle(Exception ex){
        return new ErrorDTO(ex.getMessage(), ErrorType.INTERNAL);
    }

    @ExceptionHandler({GeneralException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO generalHandle(GeneralException ex){
        return new ErrorDTO(ex.getCustomMessage(),ex.getMessage(),ErrorType.GENERAL);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO validationHandle(MethodArgumentNotValidException ex){
        List<String> listValidation = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map( fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.toList());

        return  new ErrorDTO(listValidation);
    }

}