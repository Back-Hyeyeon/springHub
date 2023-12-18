package com.mire.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.mire.view.user.Logincontroller;

public class HandlerMapping {

	private Map<String, Controller> mappings;
	
	//생성자.
	public HandlerMapping() {
		super();
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new Logincontroller());
	}
	
	public Controller getController(String path) {
		
		return mappings.get(path);
	}
	

	
}
