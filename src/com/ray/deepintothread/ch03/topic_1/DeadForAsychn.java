package com.ray.deepintothread.ch03.topic_1;

public class DeadForAsychn {

	public static void main(String[] args) throws InterruptedException {
		MyClassOne myClassOne = new MyClassOne();
		myClassOne.start();
		Thread.sleep(1000);
		myClassOne.setStop(true);
		System.out.println("---------stop----------");
	}
}

class MyClassOne extends Thread {
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
		}
		System.out.println("out");
	}
}
