package com.mire.biz.tv;

public class TVUser {
// 다현성이 나왔다.
	public static void main(String[] args) {
		BeanFactory bf = new BeanFactory();
		TV tv = (TV) bf.getBean(args[0]);
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
	}

}
