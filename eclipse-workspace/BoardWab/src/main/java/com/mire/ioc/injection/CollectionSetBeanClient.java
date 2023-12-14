package com.mire.ioc.injection;

import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionSetBeanClient {

	public static void main(String[] a) {
		// 스프링 컨테이너를 만드는 생성자이다.(객체관리 목적.)
		AbstractApplicationContext gen = new GenericXmlApplicationContext("applicationContext.xml");

		CollectionSetBean bean = (CollectionSetBean) gen.getBean("collectionSetBean");
		Set<String> set = bean.getAddressSet();
		for (String data : set) {
			System.out.println(data.toString());
		}
	}
}
