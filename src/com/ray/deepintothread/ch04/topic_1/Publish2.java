package com.ray.deepintothread.ch04.topic_1;

import java.util.HashMap;

public class Publish2 {
	private HashMap<String, Object> map = null;

	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}

	public Publish2() {
		map = new HashMap<String, Object>();
		map.put("key", "value");
	}

	public void getItemOfMap() {
		HashMap<String, Object> map = getMap();

		Object object = map.get("key");
	}
}
