package com.course.model;

/**
 * API 回應物件
 * @param <T>
 */
public class ApiResponse<T> {

	/** 回應碼 */
	private String resposeCode;
	
	/** 訊息 */
	private String message;
	
	/** 資料物件 */
	private T data;
	
    // 成功回應 靜態工廠方法
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>("200", "成功", data);
    }

    // 失敗回應 靜態工廠方法
    public static <T> ApiResponse<T> error(String code, String message) {
        return new ApiResponse<>(code, message, null);
    }
    
    // 失敗回應 靜態工廠方法
    public static <T> ApiResponse<T> error(String code, String message, T data) {
        return new ApiResponse<>(code, message, data);
    }

	public ApiResponse() {
		super();
	}

	public ApiResponse(String resposeCode, String message, T data) {
		super();
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
