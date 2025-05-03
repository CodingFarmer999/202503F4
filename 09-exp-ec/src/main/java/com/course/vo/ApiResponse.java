package com.course.vo;

public class ApiResponse<T> {
	
    private String resposeCode;

    private String message;

    private T data;

    public static <T> ApiResponse<T> success(T data) {
    	return new ApiResponse<>("200", "成功", data);
    }
    
    public static <T> ApiResponse<T> error(String code, String message) {
    	return new ApiResponse<>(code, message, null);
    }
    
	public ApiResponse() {
		
	}

	public ApiResponse(String resposeCode, String message, T data) {
		this.resposeCode = resposeCode;
		this.message = message;
		this.data = data;
	}


	public String getResposeCode() {
		return resposeCode;
	}

	public void setResposeCode(String resposeCode) {
		this.resposeCode = resposeCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
    
}
