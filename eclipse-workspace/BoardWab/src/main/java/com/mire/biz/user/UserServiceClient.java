package com.mire.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {

		//
		AbstractApplicationContext beanPink = new GenericXmlApplicationContext("applicationContext.xml");

		UserService userService = (UserService) beanPink.getBean("userService");

		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
//		vo.setName("한글");
//		vo.setRole("테스트");

		UserVO user = userService.getUser(vo);
		if (user != null && user.getName() != null) {
			System.out.println(user.getName() + "님 환영합니다.");
		} else {
			System.out.println("로그인 안됨");
		}

//		if(user != null) {
//			System.out.println(user.getName()+"님 환영합니다.");
//		}else {
//			System.out.println(user);
//			System.out.println("로그인 안됨");
//		}
		beanPink.close();
	}

}
