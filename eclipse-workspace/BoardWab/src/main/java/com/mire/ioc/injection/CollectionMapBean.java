package com.mire.ioc.injection;

import java.util.Map;

public class CollectionMapBean {
	private Map<String,String> addressMap;

	public Map<String, String> getAddressMap() {
		return addressMap;
	}

	public void setAddressMap(Map<String, String> addressMap) {
		this.addressMap = addressMap;
	}


}
