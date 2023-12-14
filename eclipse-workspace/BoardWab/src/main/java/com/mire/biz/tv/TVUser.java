package com.mire.biz.tv;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
// 다현성이 나왔다.
	public static void main(String[] args) throws InterruptedException {
		//스프링 컨테이너를 만드는 생성자이다.(객체관리 목적.)
		AbstractApplicationContext gen = new GenericXmlApplicationContext("applicationContext.xml");
		
		// Spring "싱글톤기능" 객체의 주소가 다 같다.
		TV tv = (TV) gen.getBean("stv");
		
//		TV tv1 = (TV) gen.getBean("tv");
//		TV tv2 = (TV) gen.getBean("tv");
//		TV tv3 = (TV) gen.getBean("tv");
//		System.out.println(tv1.toString());
//		System.out.println(tv2.toString());
//		System.out.println(tv3.toString());
//		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		//5초 뒤에 나오게함
//		Thread.sleep(5000);
		
		System.out.println(" ");
		//new는 객체의 주소가 각각 다르다.
//		TV tv4 = new SamaungTV();
//		TV tv5 = new SamaungTV();
//		TV tv6 = new SamaungTV();
//		System.out.println(tv4.toString());
//		System.out.println(tv5.toString());
//		System.out.println(tv6.toString());
		
//		tv1.powerOn();
//		tv1.powerOff();
//		tv1.volumeUp();
//		tv1.volumeDown();
//		
		System.out.println("spting container end");
		gen.close();
	}

}
