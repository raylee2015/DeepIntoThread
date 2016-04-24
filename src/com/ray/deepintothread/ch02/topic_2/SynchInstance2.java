package com.ray.deepintothread.ch02.topic_2;

public class SynchInstance2 {
	public static void main(String[] args) throws InterruptedException {
		MyTestObjectTwo myTestObjectTwo = new MyTestObjectTwo();
		for (int i = 0; i < 5; i++) {
			ThreadTwo threadTwo = new ThreadTwo(myTestObjectTwo);
			Thread thread = new Thread(threadTwo);
			thread.setName("" + i);
			thread.start();
		}
	}
}

class ThreadTwo implements Runnable {

	private MyTestObjectTwo myTestObjectTwo;

	public ThreadTwo(MyTestObjectTwo myTestObjectTwo) {
		this.myTestObjectTwo = myTestObjectTwo;
	}

	@Override
	public void run() {
		try {
			if (Integer.parseInt(Thread.currentThread().getName()) % 2 == 0) {
				myTestObjectTwo.test1();
			} else {
				myTestObjectTwo.test2();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyTestObjectTwo {
	public synchronized void test1() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " method test1 begin");
		System.out.println(Thread.currentThread().getName() + " method test1 waiting");
		System.out.println(Thread.currentThread().getName() + " method test1 end");
	}

	public synchronized void test2() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " method test2 begin");
		System.out.println(Thread.currentThread().getName() + " method test2 waiting");
		System.out.println(Thread.currentThread().getName() + " method test2 end");
	}
}