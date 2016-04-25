package com.ray.deepintothread.ch02.topic_4;

public class DirtyRead3 {
	public static void main(String[] args) throws InterruptedException {
		MyTestObjectThree myTestObjectThree = new MyTestObjectThree();
		ThreadThree threadThree = new ThreadThree(myTestObjectThree);
		Thread thread = new Thread(threadThree);
		thread.start();
		ThreadFour threadFour = new ThreadFour(myTestObjectThree);
		Thread thread1 = new Thread(threadFour);
		thread1.start();
	}
}

class ThreadThree implements Runnable {

	private MyTestObjectThree myTestObjectThree;

	public ThreadThree(MyTestObjectThree myTestObjectThree) {
		this.myTestObjectThree = myTestObjectThree;
	}

	@Override
	public void run() {
		myTestObjectThree.setValue(1, "ray");
	}
}

class ThreadFour implements Runnable {

	private MyTestObjectThree myTestObjectThree;

	public ThreadFour(MyTestObjectThree myTestObjectThree) {
		this.myTestObjectThree = myTestObjectThree;
	}

	@Override
	public void run() {
		myTestObjectThree.getValue();
	}
}

class MyTestObjectThree {
	private int id = 0;
	private String name = "init";

	public synchronized void setValue(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public synchronized void getValue() {
		System.out.println("id:" + id + " name:" + name);
	}
}