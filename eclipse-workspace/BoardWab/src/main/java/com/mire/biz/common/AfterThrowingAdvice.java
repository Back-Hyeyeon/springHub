package com.mire.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
@Service
@Aspect
public class AfterThrowingAdvice {
	
	
//	@Pointcut("execution(* com.mire.biz..*Impl.*(..))")
//	public void allPointCut() {}
//	@Pointcut("execution(* com.mire.biz..*Impl.get*(..))")
//	public void getPointCut() {}
	
	@AfterThrowing(pointcut = "PointCutCommon.allPointCut()", throwing = "exceptObj")
	public void afterThrowingAdvice(JoinPoint jp, Exception exceptObj) {
		String name = jp.getSignature().getName();
		String message = exceptObj.getMessage();
		
		if(exceptObj instanceof NumberFormatException) {
			System.out.println("NumberFormatException [예외 처리］ 비즈니스 로직 수행 함수명 : "+name+" 예외처리 매용 : "+ message.toString());
		}else if(exceptObj instanceof IllegalArgumentException){
			System.out.println("IllegalArgumentException "+name+" 예외처리 매용 : "+ message.toString());
		}else if(exceptObj instanceof Exception){
			System.out.println("Exception"+name+" 예외처리 매용 : "+ message.toString());
		}else {
			System.out.println("무엇? 검포 긔긔!");
		}
		
	}
}
