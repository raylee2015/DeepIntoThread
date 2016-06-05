package com.ray.deepintothread.ch03.topic_1;

public class SolveDeadFor implements Runnable {
	private boolean isStop = false;

	public boolean isStop() {
		return isStop;
	}

	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}

	public void test() throws InterruptedException {
		while (!isStop) {
			System.out.println("Thread name:" + Thread.currentThread().getName());
			Thread.sleep(200);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SolveDeadFor deadFor = new SolveDeadFor();
		Thread thread = new Thread(deadFor);
		thread.start();

		Thread.sleep(1000);
		deadFor.setStop(true);
		System.out.println("-------stop--------");
	}

	@Override
	public void run() {
		try {
			test();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
