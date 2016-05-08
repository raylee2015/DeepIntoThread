package com.ray.deepintothread.ch02.topic_16;

/**
 * 
 * @author RayLee
 *
 */
public class SynchBlock2 {
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

	private int id = 1;

	public ThreadFive(MyService3 myService) {
		this.myService = myService;
	}

	@Override
	public void run() {
		try {
			myService.updateA(id);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadSix implements Runnable {

	private MyService3 myService;

	private int id = 1;

	public ThreadSix(MyService3 myService) {
		this.myService = myService;
	}

	@Override
	public void run() {
		try {
			myService.updateB(id);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyService3 {
	public void updateA(Integer id) throws InterruptedException {
		synchronized (id) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " " + id++);
				Thread.sleep(50);
			}
		}
	}

	public void updateB(Integer id) throws InterruptedException {
		synchronized (id) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " " + id++);
				Thread.sleep(100);
			}
		}
	}

}
