package com.mire.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {

		//
		AbstractApplicationContext beanPink = new GenericXmlApplicationContext("applicationContext.xml");

		UserService userService = (UserService) beanPink.getBean("userService");
		
		UserVO vo = new UserVO();
		vo.setId("aaa");
		vo.setPassword("1234");
//		vo.setName("백");
//		vo.setRole("아무거나");
		
		UserVO user = userService.getUser(vo);
		if(user != null && user.getName() != null) {
		    System.out.println(user.getName()+"님 환영합니다.");
		} else {
		    System.out.println("로그인 실패");
		}
		
//		if(user != null) {
//			System.out.println(user.getName()+"님 환영합니다.");
//		}else {
//			System.out.println(user);
//			System.out.println("로그인 실패");
//		}
		beanPink.close();
	}

}
