package com.ray.deepintothread.ch01.topic_3;

public class CurrentThreadSample {
	public static void main(String[] args) {
		ThreadFive threadFive = new ThreadFive();
		Thread thread = new Thread(threadFive);
		thread.setName("myThread");// 设置运行线程的名称
		threadFive.setName("threadFive");// 设置实例的名称
		threadFive.myTest();
		thread.start();
	}
}

class ThreadFive extends Thread {
	public void myTest() {
		show();
	}

	private void show() {
		System.out.println("----------begin----------");
		// 这里指的是执行这个线程的名称
		System.out.println("Thread name:" + Thread.currentThread().getName());
		System.out.println(this);
		// this.getName指的是这个实例的名称
		// 由于是继承Thread，Thread本身可以设置名称
		System.out.println("Instance name:" + this.getName());
		System.out.println("----------end----------");
	}

	@Override
	public void run() {
		super.run();
		show();
	}
}