package com.course.advise;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.course.model.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// 針對 MethodArgumentNotValidException 例外進行處理方法
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ApiResponse<Map<String, String>>> handleException(MethodArgumentNotValidException e) {
        Map<String, String> errorMap = new HashMap<>();

        // 把所有欄位錯誤放入 map 中
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
        	System.out.println(fieldError.getDefaultMessage());
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        
        // 回傳自訂格式的錯誤回應（HTTP 200，responseCode 代表錯誤）
        ApiResponse<Map<String, String>> response = ApiResponse.error("401", "參數驗證錯誤", errorMap);

        return ResponseEntity.ok(response);
    }
}
