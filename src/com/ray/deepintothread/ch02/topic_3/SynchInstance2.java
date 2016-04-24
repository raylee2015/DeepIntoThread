package com.ray.deepintothread.ch02.topic_3;

public class SynchInstance2 {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			ThreadTwo threadTwo = new ThreadTwo();
			Thread thread = new Thread(threadTwo);
			thread.setName("" + i);
			thread.start();
		}
	}
}

class ThreadTwo implements Runnable {

	@Override
	public void run() {
		try {
			if (Integer.parseInt(Thread.currentThread().getName()) % 2 == 0) {
				MyTestObjectTwo.test1();
			} else {
				MyTestObjectTwo.test2();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyTestObjectTwo {
	public static synchronized void test1() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " method test1 begin");
		System.out.println(Thread.currentThread().getName() + " method test1 waiting");
		System.out.println(Thread.currentThread().getName() + " method test1 end");
	}

	public static synchronized void test2() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " method test2 begin");
		System.out.println(Thread.currentThread().getName() + " method test2 waiting");
		System.out.println(Thread.currentThread().getName() + " method test2 end");
	}
}