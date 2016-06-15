package com.ray.deepintothread.ch04.topic_1;

import java.util.HashMap;

public class Publish {
	private HashMap<String, Object> map = null;

	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}

	public Publish() {
		map = new HashMap<String, Object>();
	}
}
