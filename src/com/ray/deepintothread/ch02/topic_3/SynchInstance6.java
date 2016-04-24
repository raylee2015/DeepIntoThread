package com.ray.deepintothread.ch02.topic_3;

public class SynchInstance6 {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 2; i++) {
			ThreadSix threadSix = new ThreadSix();
			Thread thread = new Thread(threadSix);
			thread.setName("" + i);
			thread.start();
		}
	}
}

class ThreadSix implements Runnable {

	@Override
	public void run() {
		try {
			if (Integer.parseInt(Thread.currentThread().getName()) % 2 == 0) {
				MyTestObjectSix.test1();
			} else {
				MyTestObjectSix.test2();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyTestObjectSix {
	public static synchronized void test1() throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			Thread.sleep(100);
		}
	}

	public static synchronized void test2() throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			Thread.sleep(100);
		}
	}
}