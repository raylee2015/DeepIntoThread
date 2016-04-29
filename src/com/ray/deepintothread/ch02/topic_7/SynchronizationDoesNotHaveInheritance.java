package com.ray.deepintothread.ch02.topic_7;

/**
 * 从头认识多线程-2.6 同步是不具备继承性的<br>
 * http://blog.csdn.net/raylee2007/article/details/51279840<br>
 * 
 * @author RayLee
 *
 */
public class SynchronizationDoesNotHaveInheritance {
	public static void main(String[] args) throws InterruptedException {
		Sub sub = new Sub();
		Father father = new Father();
		ThreadOne threadOne = new ThreadOne(father);
		Thread thread = new Thread(threadOne);
		thread.start();
		ThreadTwo threadTwo = new ThreadTwo(father);
		Thread thread2 = new Thread(threadTwo);
		thread2.start();
	}
}

class ThreadOne implements Runnable {

	private Father father;

	public ThreadOne(Father sub) {
		this.father = sub;
	}

	@Override
	public void run() {
		father.service();
	}
}

class ThreadTwo implements Runnable {

	private Father father;

	public ThreadTwo(Father father) {
		this.father = father;
	}

	@Override
	public void run() {
		father.service();
	}
}

class Father {
	protected int count = 0;

	public synchronized void service() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Thread name:" + Thread.currentThread().getName() + " count:" + count++);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Sub extends Father {
	@Override
	public void service() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Thread name:" + Thread.currentThread().getName() + " count:" + count++);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}