package com.mire.biz.tv;

public class LgTV implements TV{

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
