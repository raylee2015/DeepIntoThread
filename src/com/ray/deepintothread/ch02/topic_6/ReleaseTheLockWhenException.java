package com.ray.deepintothread.ch02.topic_6;

/**
 * 从头认识多线程-2.5 当异常出现时，线程自动释放锁<br>
 * blog:http://blog.csdn.net/raylee2007/article/details/51270010<br>
 * 
 * @author RayLee
 *
 */
public class ReleaseTheLockWhenException {
	public static void main(String[] args) throws InterruptedException {
		MyTestObjectOne myTestObjectOne = new MyTestObjectOne();
		ThreadOne threadOne = new ThreadOne(myTestObjectOne);
		Thread thread = new Thread(threadOne);
		thread.start();
		ThreadTwo threadTwo = new ThreadTwo(myTestObjectOne);
		Thread thread2 = new Thread(threadTwo);
		thread2.start();
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
			myTestObjectOne.service_1();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadTwo implements Runnable {

	private MyTestObjectOne myTestObjectOne;

	public ThreadTwo(MyTestObjectOne myTestObjectOne) {
		this.myTestObjectOne = myTestObjectOne;
	}

	@Override
	public void run() {
		try {
			myTestObjectOne.service_2();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyTestObjectOne {
	public synchronized void service_1() throws InterruptedException {
		System.out.println("service_1 begin");
		System.out.println("service_1 working");
		{// 人造异常
			String a = null;
			a.toString();
		}
		Thread.sleep(1000);
		System.out.println("service_1 end");
	}

	public synchronized void service_2() throws InterruptedException {
		System.out.println("service_2 begin");
		System.out.println("service_2 working");
		Thread.sleep(1000);
		System.out.println("service_2 end");
	}
}