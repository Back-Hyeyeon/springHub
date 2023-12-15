package com.mire.biz.common;



import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.mire.biz.user.UserVO;
@Service
@Aspect
public class AfterReturningAdvice {

	
	//<aop:pointcut expression="execution(* com.mire.biz..*Impl.*(..))" id="allPointCut" />
		//아래와 같은 기능.
//		@Pointcut("execution(* com.mire.biz..*Impl.*(..))")
//		public void allPointCut() {}
//		
		//<aop:pointcut expression="execution(* com.mire.biz..*Impl.get*(..))" id="getPointCut" />
//		@Pointcut("execution(* com.mire.biz..*Impl.get*(..))")
//		public void getPointCut() {}
	
	
	
		@AfterReturning(pointcut = "PointCutCommon.getPointCut()", returning = "retObject")
	public void afterReturninLog(JoinPoint jp, Object retObject) {
		String name = jp.getSignature().getName();
		Object[] arge = jp.getArgs();
		Object obj = jp.getTarget();
		Date date = new Date();
		
		//리턴값을 가지고 확인 가능(인스턴스..오브?)
		if(retObject instanceof UserVO){
			UserVO userVO=(UserVO)retObject;
			if(userVO.getRole().equals("Admin")) {
				System.out.println(userVO.getName() + "님 환영합니다."+date.toString());
			}else {
				System.out.println(userVO.getName() + "님 방문함"+date.toString());
				
			}
		}
		
		System.out.println("［공통 로그 AfterReturningAdvice］ 비즈니스 로직 수행 후 리던 동작 메소드는 : " + name + "매개변수는 : " + arge[0].toString()+"class : " + obj);
		
		}

}
