package com.mire.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

public class AroundAdvice {
//AOP를 이용한 성능처리(성능체크) 확인
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[aroundLog start]");
		
		StopWatch stopWatch=new StopWatch();
		stopWatch.start();
		Object obj = pjp.proceed();
		stopWatch.stop();
		String name = pjp.getSignature().getName();
		System.out.println("[aroundLog stop]  "+ name +" 수핼시간  "+stopWatch.getTotalTimeMillis()+"ms");
		return obj;
	}

}
