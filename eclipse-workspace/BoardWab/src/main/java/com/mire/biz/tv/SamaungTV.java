package com.mire.biz.tv;

public class SamaungTV implements TV {
	//멤버변수 추가.
	private Speaker speaker;
	private int pric;
	//생성자로 객체주입
//	public SamaungTV(Speaker speaker, int pric) {
//		super();
//		this.speaker = speaker;
//		this.pric = pric;
//	}

	
	
	public SamaungTV() {
		System.out.println("SamaungTV() 객체생성");
	}
	
	
	public void powerOn() {
		System.out.println("SamaungTV  on pric : " + pric);
	}
	public void powerOff() {
		System.out.println("SamaungTV  off pric : " + pric);
	}

	public void volumeUp() {
//		System.out.println("SamaungTV  volumeUp");
		speaker.volumeUP();
	}
	public void volumeDown() {
//		System.out.println("SamaungTV  volumeDown");
		speaker.volumeDown();
	}
	
	//set로 주입
	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker 호출");
		this.speaker = speaker;
	}
	
	
	public void setPric(int pric) {
		System.out.println("setPric 호출");
		this.pric = pric;
	}
	
	
	

}
