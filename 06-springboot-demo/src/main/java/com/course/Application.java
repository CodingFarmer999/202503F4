package com.course;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
//		String[] beans = ctx.getBeanDefinitionNames();
//		for (String name : beans) {
//			System.out.println(name);
//		}
		
		Logger logger = LoggerFactory.getLogger(Application.class);
		logger.trace("我是trace");
		logger.debug("我是debug");
		logger.info("我是info");
		logger.warn("我是warn");
		logger.error("我是error");
		
		
		try {
			List<String> testList = null;
			
			boolean init = false;
			if (init) {
				testList = new ArrayList<>();
			}

			logger.debug("" + testList.size());
		} catch (Exception e) {
			logger.error("出事了", e);
		}
		
	}

}
