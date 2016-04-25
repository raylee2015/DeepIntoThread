package com.ray.deepintothread.ch02.topic_4;

public class DirtyRead {
	public static void main(String[] args) throws InterruptedException {
		MyTestObjectOne myTestObjectOne = new MyTestObjectOne();
		ThreadOne threadTwo = new ThreadOne(myTestObjectOne);
		Thread thread = new Thread(threadTwo);
		thread.start();
		System.out.println("id:" + myTestObjectOne.getId() + " name:" + myTestObjectOne.getName());
	}
}

class ThreadOne implements Runnable {

	private MyTestObjectOne myTestObjectOne;

	public ThreadOne(MyTestObjectOne myTestObjectOne) {
		this.myTestObjectOne = myTestObjectOne;
	}

	@Override
	public void run() {
		myTestObjectOne.setId(1);
		myTestObjectOne.setName("ray");
	}
}

class MyTestObjectOne {
	private int id = 0;
	private String name = "init";

	public int getId() {
		return id;
	}

	public synchronized void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}
}