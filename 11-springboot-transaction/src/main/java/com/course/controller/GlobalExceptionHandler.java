package com.course.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.course.exception.ActionException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	// 日誌記錄器
	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * 處理全部的異常
	 * @param e
	 * @return
	 */
    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<String> handleException(Exception e) {
     	logger.error("我是Runtime Exception");
        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    /**
     * 自定義ActionException
     * @param e
     * @return
     */
    @ExceptionHandler(value = {ActionException.class})
    public ResponseEntity<ActionException> handleActionException(ActionException e) {
     	logger.error("我是ActionException");
        // return new ResponseEntity<>("ActionException例外: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
     	return ResponseEntity.internalServerError().body(e);
    }
}
