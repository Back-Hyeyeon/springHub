package com.mire.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {

	public void afterThrowingAdvice(JoinPoint jp, Exception exceptObj) {
		String name = jp.getSignature().getName();
		String message = exceptObj.getMessage();
		
		if(exceptObj instanceof NumberFormatException) {
			System.out.println("NumberFormatException [예외 처리］ 비즈니스 로직 수행 함수명 : "+name+" 예외처리 매용 : "+ message.toString());
		}else if(exceptObj instanceof IllegalArgumentException){
			System.out.println("IllegalArgumentException ");
		}else if(exceptObj instanceof Exception){
			System.out.println("Exception");
		}else {
			System.out.println("무엇? 검포 긔긔!");
		}
		
	}
}
