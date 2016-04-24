package com.ray.deepintothread.ch02.topic_3;

public class SynchInstance5 {
	public static void main(String[] args) throws InterruptedException {
		MyTestObjectFive myTestObjectFive = new MyTestObjectFive();
		for (int i = 0; i < 2; i++) {
			ThreadFive threadFive = new ThreadFive(myTestObjectFive);
			Thread thread = new Thread(threadFive);
			thread.setName("" + i);
			thread.start();
		}
	}
}

class ThreadFive implements Runnable {

	private MyTestObjectFive myTestObjectFive;

	public ThreadFive(MyTestObjectFive myTestObjectFive) {
		this.myTestObjectFive = myTestObjectFive;
	}

	@Override
	public void run() {
		try {
			if (Integer.parseInt(Thread.currentThread().getName()) % 2 == 0) {
				myTestObjectFive.test1();
			} else {
				myTestObjectFive.test2();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyTestObjectFive {
	public synchronized void test1() throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			Thread.sleep(100);
		}
	}

	public synchronized void test2() throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			Thread.sleep(100);
		}
	}
}