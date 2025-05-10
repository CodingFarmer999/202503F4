package com.course.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.course.excpetion.ActionException;
import com.course.excpetion.ErrorResponse;


@RestControllerAdvice
public class ActionExceptionHandler {
    @ExceptionHandler(ActionException.class)
    public ResponseEntity<ErrorResponse> handleActionException(ActionException ex) {
        ErrorResponse response = new ErrorResponse(ex.getErrorCode(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
