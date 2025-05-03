package com.course.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.course.vo.ProductVo;

//@Component
//@Aspect
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
	
//	@Around("pointCutMethod()")
	public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
	    logger.info("切面 AopAspect.aroundAdvice() -> @Around通知 proceed之前，被切的方法名稱：" + joinPoint.getSignature().getName());
	    // 需要Throw Exception

	    joinPoint.proceed();
 
	    logger.info("切面 AopAspect.aroundAdvice() -> @Around通知 proceed之後");
	}
	
	@AfterReturning(value= "pointCutMethod()", returning = "result")
	public void afterReturnAdvice(JoinPoint joinPoint, ProductVo result) {
	    logger.info("切面 AopAspect.afterReturnAdvice() -> @AfterReturning通知，在方法調用之後才調用，被切的方法名稱：" + joinPoint.getSignature().getName());
	    logger.info("切面 AopAspect.afterReturnAdvice() -> @AfterReturning通知，在方法調用之後才調用，被切的方法的回傳值：" + result);
	}
	
	@AfterThrowing(value= "pointCutMethod()", throwing = "ex")
	public void afterThrowiungAdvice(JoinPoint joinPoint, Throwable ex) {
	    logger.info("切面 AopAspect.afterThrowiungAdvice() -> @AfterThrowing通知，在方法發生異常時才調用，被切的方法名稱：" + joinPoint.getSignature().getName());
	    logger.info("切面 AopAspect.afterThrowiungAdvice() -> @AfterThrowing通知，異常例外：" + ex);
	}
}
