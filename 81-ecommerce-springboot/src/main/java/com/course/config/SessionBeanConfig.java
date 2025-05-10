package com.course.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.course.model.vo.UserVo;

@Configuration
public class SessionBeanConfig {
	
//	/**
//	 * 使用者登入Session資料
//	 * @return
//	 */
//	@Bean
//	@SessionScope
//	UserVo getSessionUser() {
//		return new UserVo();
//	}
}
