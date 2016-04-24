package com.ray.deepintothread.ch02.topic_2;

public class SynchInstance1 {
	public static void main(String[] args) throws InterruptedException {
		MyTestObjectOne myTestObjectOne = new MyTestObjectOne();
		for (int i = 0; i < 5; i++) {
			ThreadOne threadTwo = new ThreadOne(myTestObjectOne);
			Thread thread = new Thread(threadTwo);
			thread.setName("" + i);
			thread.start();
		}
	}
}

class ThreadOne implements Runnable {

	private MyTestObjectOne myTestObjectOne;

	public ThreadOne(MyTestObjectOne myTestObjectOne) {
		this.myTestObjectOne = myTestObjectOne;
	}

	@Override
	public void run() {
		try {
			if (Integer.parseInt(Thread.currentThread().getName()) % 2 == 0) {
				myTestObjectOne.test1();
			} else {
				myTestObjectOne.test2();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyTestObjectOne {
	public void test1() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " method test1 begin");
		System.out.println(Thread.currentThread().getName() + " method test1 waiting");
		Thread.sleep(200);
		System.out.println(Thread.currentThread().getName() + " method test1 end");
	}

	public void test2() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " method test2 begin");
		System.out.println(Thread.currentThread().getName() + " method test2 waiting");
		Thread.sleep(200);
		System.out.println(Thread.currentThread().getName() + " method test2 end");
	}
}