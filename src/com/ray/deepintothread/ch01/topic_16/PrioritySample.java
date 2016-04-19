package com.ray.deepintothread.ch01.topic_16;

import java.util.Random;

public class PrioritySample {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			ThreadOne threadOne = new ThreadOne();
			threadOne.setName("high priority");
			threadOne.setPriority(6);
			threadOne.start();
			ThreadTwo threadTwo = new ThreadTwo();
			threadTwo.setName("low priority");
			threadTwo.setPriority(5);
			threadTwo.start();
		}
	}
}

class ThreadOne extends Thread {

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			Random random = new Random();
			random.nextInt(50);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName() + " " + (endTime - startTime));
	}
}

class ThreadTwo extends Thread {

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			Random random = new Random();
			random.nextInt(50);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName() + " " + (endTime - startTime));
	}
}
