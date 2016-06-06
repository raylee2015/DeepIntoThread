package com.ray.deepintothread.ch03.topic_1;

public class DeadForAsychn2 {

	public static void main(String[] args) throws InterruptedException {
		MyClassTwo myClassOne = new MyClassTwo();
		myClassOne.start();
		Thread.sleep(1000);
		myClassOne.setStop(true);
		System.out.println("---------stop----------");
	}
}

class MyClassTwo extends Thread {
	private boolean isStop = false;

	public boolean isStop() {
		return isStop;
	}

	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}

	@Override
	public void run() {
		System.out.println("running");
		while (!isStop) {
			System.out.println(Thread.currentThread().getName());
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("out");
	}
}
