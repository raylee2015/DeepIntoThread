package com.ray.deepintothread.ch02.topic_19;

/**
 * 
 * @author RayLee
 *
 */
public class MonitorOfSynch3 {
	public static void main(String[] args) throws InterruptedException {
		MyService3 myService = new MyService3();
		ThreadFive threadFive = new ThreadFive(myService);
		Thread thread = new Thread(threadFive);
		thread.setName("thread A");
		thread.start();
		ThreadSix threadSix = new ThreadSix(myService);
		Thread thread2 = new Thread(threadSix);
		thread2.setName("thread B");
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

	private String name = "ray";

	public void updateA() throws InterruptedException {
		synchronized (name) {
			for (int i = 0; i < 5; i++) {
				System.out.println("name:" + name);
				// 修改监视器
				name += "-" + i;
				System.out.println(Thread.currentThread().getName() + " " + name);
				Thread.sleep(50);
				// 恢复原形
				name = "ray";
				System.out.println("-------------------");
			}
		}
	}

	public void updateB() throws InterruptedException {
		synchronized (name) {
			for (int i = 0; i < 5; i++) {
				System.out.println("name:" + name);
				// 修改监视器
				name += "-" + i;
				System.out.println(Thread.currentThread().getName() + " " + name);
				Thread.sleep(100);
				// 恢复原形
				name = "ray";
				System.out.println("-------------------");
			}
		}
	}

}
