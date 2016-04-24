package com.ray.deepintothread.ch02.topic_3;

public class SynchInstance4 {
	public static void main(String[] args) throws InterruptedException {
		MyTestObjectFour myTestObjectThree = new MyTestObjectFour();
		for (int i = 0; i < 2; i++) {
			ThreadFour threadFour = new ThreadFour(myTestObjectThree);
			Thread thread = new Thread(threadFour);
			thread.setName("" + i);
			thread.start();
		}
	}
}

class ThreadFour implements Runnable {

	private MyTestObjectFour myTestObjectThree;

	public ThreadFour(MyTestObjectFour myTestObjectThree) {
		this.myTestObjectThree = myTestObjectThree;
	}

	@Override
	public void run() {
		try {
			if (Integer.parseInt(Thread.currentThread().getName()) % 2 == 0) {
				myTestObjectThree.test1();
			} else {
				MyTestObjectFour.test2();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyTestObjectFour {
	public synchronized void test1() throws InterruptedException {
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