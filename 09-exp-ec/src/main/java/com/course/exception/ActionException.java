package com.course.exception;

/**
 * 自定義Exception
 */
@SuppressWarnings("serial")
public class ActionException extends Exception {

    private String errorCode;
    
    public ActionException() {
    	super();
    }

    public ActionException(String message) {
		super(message);
    }
    
    public ActionException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
}