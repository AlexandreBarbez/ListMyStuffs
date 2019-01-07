package org.halx.listMyStuffs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StuffNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(StuffNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String stuffNotFoundHandler(StuffNotFoundException ex){
        return ex.getMessage();
    }
}
