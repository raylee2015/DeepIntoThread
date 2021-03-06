package com.ray.deepintothread.ch03.topic_1;

public class DeadForSynch {
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
		DeadForSynch deadFor = new DeadForSynch();
		deadFor.test();
		deadFor.setStop(true);
	}
}
