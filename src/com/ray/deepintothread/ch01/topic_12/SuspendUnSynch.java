package com.ray.deepintothread.ch01.topic_12;

public class SuspendUnSynch {
	public static void main(String[] args) throws InterruptedException {
		MyObject myObject = new MyObject();

		ThreadOne threadOne = new ThreadOne(myObject);
		Thread thread = new Thread(threadOne);
		thread.start();

		ThreadTwo threadTwo = new ThreadTwo(myObject);
		Thread thread2 = new Thread(threadTwo);
		thread2.start();
	}
}

class MyObject {
	private int id = 0;

	private String name = "init";

	@SuppressWarnings("deprecation")
	public void set(int id, String name) {
		this.id = id;
		Thread.currentThread().suspend();
		this.name = name;
	}

	public void printStr() {
		System.out.println(id + " " + name);
	}
}

class ThreadOne implements Runnable {

	private MyObject myObject;

	public ThreadOne(MyObject myObject) {
		this.myObject = myObject;
	}

	@Override
	public void run() {
		myObject.set(1, "ray");
	}
}

class ThreadTwo implements Runnable {

	private MyObject myObject;

	public ThreadTwo(MyObject myObject) {
		this.myObject = myObject;
	}

	@Override
	public void run() {
		myObject.printStr();
	}
}