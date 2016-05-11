package com.ray.deepintothread.ch02.topic_17;

/**
 * 
 * @author RayLee
 *
 */
public class SynchClass2 {
	public static void main(String[] args) throws InterruptedException {
		ThreadThree threadThree = new ThreadThree();
		Thread thread = new Thread(threadThree);
		thread.start();
		ThreadFour threadFour = new ThreadFour();
		Thread thread2 = new Thread(threadFour);
		thread2.start();
	}
}

class ThreadThree implements Runnable {

	@Override
	public void run() {
		try {
			MyService2.updateA();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadFour implements Runnable {

	@Override
	public void run() {
		try {
			MyService2.updateB();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyService2 {
	private static int id = 0;

	public static void updateA() throws InterruptedException {
		synchronized (MyService2.class) {// 这里可以使用Object.class等class替代
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " " + id++);
				Thread.sleep(50);
			}
		}
	}

	public static void updateB() throws InterruptedException {
		synchronized (String.class) {// 这里可以使用Object.class等class替代
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " " + id++);
				Thread.sleep(100);
			}
		}
	}

}
