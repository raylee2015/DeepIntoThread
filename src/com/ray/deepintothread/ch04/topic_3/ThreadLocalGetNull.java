package com.ray.deepintothread.ch04.topic_3;

public class ThreadLocalGetNull {

	private int count = 0;

	public ThreadLocal<Integer> intThreadLocal = new ThreadLocal<Integer>();

	public int getCount() {
		return intThreadLocal.get();
	}

	public void addCount() {
		intThreadLocal.set(count++);
	}

	public static void main(String[] args) {
		System.out.println(new ThreadLocalGetNull().getCount());
	}
}
