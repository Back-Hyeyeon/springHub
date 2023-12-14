package com.mire.biz.tv;

import org.springframework.stereotype.Component;

@Component("lgtv")
public class LgTV implements TV{

	public LgTV() {
		System.out.println("LgTV() 객체생성");
	}
	
//	public void powOn() {
//		
//	}
//	public void powff() {
//		
//	}
//	public void speakerUp() {
//		
//	}
//	public void speakerDown() {
//		
//	}
	
	public void initMethod() {
		//applicationContext.xml 의 init
		System.out.println("lgTv의 initMethod 함수입니다");
	}
	public void destroyMethod() {
		//applicationContext.xml 의 init
		System.out.println("lgTv의 destroyMethod 함수입니다");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV  on");
		
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV  off");
		
	}
	@Override
	public void volumeUp() {
		System.out.println("LgTV  volumeUp");
		
	}
	@Override
	public void volumeDown() {
		System.out.println("LgTV  volumeDown");
		
	}

}
