package com.ray.deepintothread.ch02.topic_26;

/**
 * 
 * @author RayLee
 *
 */
public class SynchBlock {
	private Object object = new Object();

	public void test1() {
		synchronized (object) {

		}
	}

	public void test2() {
	}
}
