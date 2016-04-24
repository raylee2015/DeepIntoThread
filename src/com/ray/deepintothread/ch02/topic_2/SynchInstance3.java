package com.ray.deepintothread.ch02.topic_2;

public class SynchInstance3 {
	public static void main(String[] args) throws InterruptedException {
		MyTestObjectThree myTestObjectThree = new MyTestObjectThree();
		for (int i = 0; i < 5; i++) {
			ThreadThree threadThree = new ThreadThree(myTestObjectThree);
			Thread thread = new Thread(threadThree);
			thread.setName("" + i);
			thread.start();
		}
	}
}

class ThreadThree implements Runnable {

	private MyTestObjectThree myTestObjectThree;

	public ThreadThree(MyTestObjectThree myTestObjectThree) {
		this.myTestObjectThree = myTestObjectThree;
	}

	@Override
	public void run() {
		try {
			if (Integer.parseInt(Thread.currentThread().getName()) % 2 == 0) {
				myTestObjectThree.test1();
			} else {
				myTestObjectThree.test2();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyTestObjectThree {
	public synchronized void test1() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " method test1 begin");
		System.out.println(Thread.currentThread().getName() + " method test1 waiting");
		System.out.println(Thread.currentThread().getName() + " method test1 end");
	}

	public void test2() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " method test2 begin");
		System.out.println(Thread.currentThread().getName() + " method test2 waiting");
		System.out.println(Thread.currentThread().getName() + " method test2 end");
	}
}