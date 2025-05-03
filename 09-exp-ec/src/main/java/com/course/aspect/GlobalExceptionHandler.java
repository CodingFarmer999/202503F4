package com.course.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.course.exception.ActionException;
import com.course.vo.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// 日誌記錄器
	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

//    @ExceptionHandler(value = {RuntimeException.class})
//    public ResponseEntity<String> handleException(Exception e) {
//    	// 寫log
//    	logger.error("我是Runtime Exception");
//        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<ApiResponse<Void>> handleException(Exception e) {
		// 寫log
		logger.error("我是Runtime Exception");
		return new ResponseEntity<>(ApiResponse.error("401", "系統忙碌中"), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { ActionException.class })
	public ResponseEntity<String> handleException(ActionException e) {
		// 寫log
		logger.error("我是Action Exception");
		return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
