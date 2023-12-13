package com.mire.biz.tv;

public class BeanFactory {
	
	// 객체관리를 BeanFactory에서 담당 진행 한다.
	public Object getBean(String beanName) {
		Object obj = null;
		switch (beanName) {
		case "samaung": obj= new SamaungTV();
			break;
		case "lg": obj = new LgTV();
			break;
		case "google":
			break;
		case "naver":
			break;
		default: obj = null;
			break;
		}
		return obj;
	}
}
