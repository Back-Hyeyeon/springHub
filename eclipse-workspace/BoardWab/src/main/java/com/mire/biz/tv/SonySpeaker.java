package com.mire.biz.tv;

import org.springframework.stereotype.Component;


public class SonySpeaker implements Speaker {

	public SonySpeaker() {
		System.out.println("SonySpeaker() 객체생성");
	}

	public void volumeUP() {
		System.out.println("SonySpeaker() 볼륨업 volumeUP()");
		
	}
	public void volumeDown() {
		
		System.out.println("SonySpeaker() 볼륨다운 volumeDown()");
	}
	
}
