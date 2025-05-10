package com.course.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 圖片服務器
 */
@RestController
@RequestMapping("/image")
@CrossOrigin("http://localhost:3000")
public class ImageController {

	// 圖片存放的資料夾路徑
    private static final String IMAGE_DIRECTORY = "/Users/yaochilee/image/";

    @GetMapping("/{filename}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable String filename) {
        File file = new File(IMAGE_DIRECTORY + filename);
        
        if (!file.exists()) {
        	// 如果檔案不存在，拋出 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        try (FileInputStream fis = new FileInputStream(file);) {
            // 讀取圖片檔案並轉換為 byte 陣列
            byte[] imageData = fis.readAllBytes();
            // 設定圖片的 Content-Type 和檔案名
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, Files.probeContentType(file.toPath()));
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + file.getName() + "\"");

            return new ResponseEntity<>(imageData, headers, HttpStatus.OK);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
