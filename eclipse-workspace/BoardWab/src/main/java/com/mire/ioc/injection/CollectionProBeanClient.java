package com.mire.ioc.injection;

import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionProBeanClient {

	public static void main(String[] a) {
		// 스프링 컨테이너를 만드는 생성자이다.(객체관리 목적.)
		AbstractApplicationContext gen = new GenericXmlApplicationContext("applicationContext.xml");

		CollectionPorBean bean =  (CollectionPorBean) gen.getBean("collectionProBean");
		Properties pro = bean.getAddressPro();
		Set<Object> is =  pro.keySet();
		for (Object data : is) {
			System.out.println(data.toString() +"   "+ pro.get(data));
		}
		gen.close();
	}
}
