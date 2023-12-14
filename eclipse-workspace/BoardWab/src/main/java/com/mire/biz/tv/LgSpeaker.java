package com.mire.biz.tv;

public class LgSpeaker implements Speaker {

	public LgSpeaker() {
		System.out.println("LgSpeaker() 객체생성");
	}

	public void volumeUP() {
		System.out.println("LgSpeaker() 볼륨업 volumeUP()");
		
	}
	public void volumeDown() {
		
		System.out.println("LgSpeaker() 볼륨다운 volumeDown()");
	}
	
}
