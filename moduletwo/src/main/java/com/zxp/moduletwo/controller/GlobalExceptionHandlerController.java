package com.zxp.moduletwo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(ConstraintViolationException.class)
    public void handleConstraintViolationException(HttpServletResponse resp, ConstraintViolationException ex) throws IOException {
        String msg = ex.getMessage();
        String[] msgs = msg.split(": ");
        resp.sendError(HttpStatus.OK.value(), "-2" +  msgs[msgs.length-1]);
    }

}