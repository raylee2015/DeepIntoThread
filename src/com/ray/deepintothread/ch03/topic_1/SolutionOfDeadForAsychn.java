package com.ray.deepintothread.ch03.topic_1;

public class SolutionOfDeadForAsychn {

	public static void main(String[] args) throws InterruptedException {
		MyClassThree myClassThree = new MyClassThree();
		myClassThree.start();
		Thread.sleep(1000);
		myClassThree.setStop(true);
		System.out.println("---------stop----------");
	}
}

class MyClassThree extends Thread {
	private volatile boolean isStop = false;

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
