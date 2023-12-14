package com.mire.ioc.injection;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionListBeanClient {

	public static void main(String[] a) {
		// 스프링 컨테이너를 만드는 생성자이다.(객체관리 목적.)
		AbstractApplicationContext gen = new GenericXmlApplicationContext("applicationContext.xml");

		CollectionListBean bean = (CollectionListBean) gen.getBean("collectionListBean");
		List<String> list = bean.getAddressList();
		for (String data : list) {
			System.out.println(data.toString());
		}
		gen.close();
	}
}
