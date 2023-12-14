package com.mire.biz.tv;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
// 다현성이 나왔다.
	public static void main(String[] args) {
		
		AbstractApplicationContext gen = new GenericXmlApplicationContext("applicationContext.xml");
		
		TV tv = (TV) gen.getBean("tv");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
	}

}
