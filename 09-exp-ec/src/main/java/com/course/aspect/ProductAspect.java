package com.course.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProductAspect {

	// 日誌記錄器
	Logger logger = LoggerFactory.getLogger(ProductAspect.class);
	
	@Pointcut("execution(public * com.course.service.ProductService.*(..))")
	public void pointCutMethod() {
	    // 透由@Pointcut定義切點，方法內容維持空方法
	}
	
	@Before("pointCutMethod()")
	public void beforeAdvice(JoinPoint joinPoint) {
	    logger.info("切面 AopAspect.beforeAdvice() -> @Before通知，在方法調用前先行調用，被切的方法名稱：" + joinPoint.getSignature().getName());
	}
}
