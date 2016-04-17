package com.ray.deepintothread.ch01.topic_9;

import java.util.ArrayList;

public class StopByReturn3 {
	public static void main(String[] args) throws InterruptedException {
		ThreadOne threadTwo = new ThreadOne();
		ArrayList<Thread> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(threadTwo);
			thread.start();
			list.add(thread);
		}
		Thread.sleep(20);
		list.get(0).interrupt();
	}
}

class ThreadTwo implements Runnable {

	@Override
	public void run() {
		while (true) {
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("Thread name:" + Thread.currentThread().getName() + " return");
				return;
			}
		}
	}
}