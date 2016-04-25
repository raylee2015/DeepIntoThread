package com.ray.deepintothread.ch02.topic_4;

public class DirtyRead2 {
	public static void main(String[] args) throws InterruptedException {
		MyTestObjectTwo myTestObjectTwo = new MyTestObjectTwo();
		ThreadTwo threadTwo = new ThreadTwo(myTestObjectTwo);
		Thread thread = new Thread(threadTwo);
		thread.start();
		Thread.sleep(100);// 是否出现脏读，这里程序的执行时间，跟下面的执行时间有密切关系
		System.out.println("id:" + myTestObjectTwo.getId() + " name:" + myTestObjectTwo.getName());
	}
}

class ThreadTwo implements Runnable {

	private MyTestObjectTwo myTestObjectTwo;

	public ThreadTwo(MyTestObjectTwo myTestObjectTwo) {
		this.myTestObjectTwo = myTestObjectTwo;
	}

	@Override
	public void run() {
		myTestObjectTwo.setId(1);
		try {
			Thread.sleep(1000);// 代码执行时间
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		myTestObjectTwo.setName("ray");
	}
}

class MyTestObjectTwo {
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