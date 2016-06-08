package com.ray.deepintothread.ch03.topic_3;

public class SolutionOfDeadForAsychn {

	public static void main(String[] args) throws InterruptedException {
		MyClassTwo myClassTwo = new MyClassTwo();
		myClassTwo.start();
		Thread.sleep(1000);
		myClassTwo.setStop(true);
		System.out.println("---------stop----------");
	}
}

class MyClassTwo extends Thread {
	private Boolean isStop = false;

	public boolean isStop() {
		return isStop;
	}

	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}

	@Override
	public void run() {
		synchronized (isStop) {
			System.out.println("synchronized");
			System.out.println("running");
			while (!isStop) {

			}
			System.out.println("out");
		}
	}
}
