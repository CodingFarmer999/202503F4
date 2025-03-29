package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestMain {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		
		try (Connection conn = DriverManager.getConnection(url, "TEST", "root")) {
			System.out.println("連線成功");
		} catch (Exception e) {
			System.out.println("ERROR");
		}

	}

}
