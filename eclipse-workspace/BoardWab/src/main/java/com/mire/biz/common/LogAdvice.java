package com.mire.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
//<bean id="log" class="com.mire.biz.common.LogAdvice"/>
//<aop:aspect ref="log">
@Service
@Aspect
public class LogAdvice {
	
	//<aop:pointcut expression="execution(* com.mire.biz..*Impl.*(..))" id="allPointCut" />
	//아래와 같은 기능.
//	@Pointcut("execution(* com.mire.biz..*Impl.*(..))")
//	public void allPointCut() {}
	
	//<aop:pointcut expression="execution(* com.mire.biz..*Impl.get*(..))" id="getPointCut" />
//	@Pointcut("execution(* com.mire.biz..*Impl.get*(..))")
//	public void getPointCut() {}
	
	//<aop:aspect ref="log">
	//<aop:after method="printLog" pointcut-ref="allPointCut"/> </aop:aspect>
	//메게변수를 단다. JoinPoint / aspectj
	
	@After("PointCutCommon.allPointCut()")
	public void printLog(JoinPoint jp) {
		String name = jp.getSignature().getName();
		Object[] arge = jp.getArgs();
		Object obj = jp.getTarget();
		
		System.out.println("［공통 로그 printLog］ 비즈니스 로직 수행 전 동작 메소드는 : " + name + "매개변수는 : " + arge[0].toString());
		
	}
}
