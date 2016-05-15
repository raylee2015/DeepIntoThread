package com.ray.deepintothread.ch02.topic_20;

/**
 * 
 * @author RayLee
 *
 */
public class SolutionOfInfiniteWait2 {
	public static void main(String[] args) throws InterruptedException {
		MyService3 myService = new MyService3();
		ThreadFive threadFive = new ThreadFive(myService);
		Thread thread = new Thread(threadFive);
		thread.start();
		ThreadSix threadSix = new ThreadSix(myService);
		Thread thread2 = new Thread(threadSix);
		thread2.start();
	}
}

class ThreadFive implements Runnable {
	private MyService3 myService;

	public ThreadFive(MyService3 myService) {
		this.myService = myService;
	}

	@Override
	public void run() {
		try {
			myService.updateA();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadSix implements Runnable {

	private MyService3 myService;

	public ThreadSix(MyService3 myService) {
		this.myService = myService;
	}

	@Override
	public void run() {
		try {
			myService.updateB();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyService3 {
	private int id = 0;
	private Object object1 = new Object();
	private Object object2 = new Object();

	public void updateA() throws InterruptedException {
		//¼ÆÊýÆ÷
		int count = 0;
		synchronized (object1) {
			while (true) {
				count++;
				if (count > 3) {
					System.out.println(Thread.currentThread().getName() + " get out");
					break;
				} else {
					Thread.sleep(100);
				}
			}
		}
	}

	public synchronized void updateB() throws InterruptedException {
		synchronized (object2) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " " + id++);
				Thread.sleep(100);
			}
		}
	}

}
