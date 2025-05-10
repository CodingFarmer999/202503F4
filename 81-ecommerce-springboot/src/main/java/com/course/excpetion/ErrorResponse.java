package com.course.excpetion;

public class ErrorResponse {
	
    private final String errorCode;
    
    private final String message;

    public ErrorResponse(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

	public String getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}
}
