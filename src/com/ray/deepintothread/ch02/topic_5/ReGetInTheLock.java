package com.ray.deepintothread.ch02.topic_5;

public class ReGetInTheLock {
	public static void main(String[] args) throws InterruptedException {
		MyTestObjectOne myTestObjectOne = new MyTestObjectOne();
		ThreadOne threadOne = new ThreadOne(myTestObjectOne);
		Thread thread = new Thread(threadOne);
		thread.start();
	}
}

class ThreadOne implements Runnable {

	private MyTestObjectOne myTestObjectOne;

	public ThreadOne(MyTestObjectOne myTestObjectOne) {
		this.myTestObjectOne = myTestObjectOne;
	}

	@Override
	public void run() {
		myTestObjectOne.service_1();
	}
}

class MyTestObjectOne {
	public synchronized void service_1() {
		System.out.println("service_1 begin");
		service_2();
		System.out.println("service_1 end");
	}

	public synchronized void service_2() {
		System.out.println("service_2 begin");
		service_3();
		System.out.println("service_2 end");
	}

	public synchronized void service_3() {
		System.out.println("service_3 begin");
		System.out.println("service_3 end");
	}
}