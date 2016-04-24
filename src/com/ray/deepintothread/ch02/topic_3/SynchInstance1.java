package com.ray.deepintothread.ch02.topic_3;

public class SynchInstance1 {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			ThreadOne threadTwo = new ThreadOne();
			Thread thread = new Thread(threadTwo);
			thread.setName("" + i);
			thread.start();
		}
	}
}

class ThreadOne implements Runnable {

	@Override
	public void run() {
		try {
			if (Integer.parseInt(Thread.currentThread().getName()) % 2 == 0) {
				MyTestObjectOne.test1();
			} else {
				MyTestObjectOne.test2();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyTestObjectOne {
	public static void test1() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " method test1 begin");
		System.out.println(Thread.currentThread().getName() + " method test1 waiting");
		Thread.sleep(200);
		System.out.println(Thread.currentThread().getName() + " method test1 end");
	}

	public static void test2() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " method test2 begin");
		System.out.println(Thread.currentThread().getName() + " method test2 waiting");
		Thread.sleep(200);
		System.out.println(Thread.currentThread().getName() + " method test2 end");
	}
}