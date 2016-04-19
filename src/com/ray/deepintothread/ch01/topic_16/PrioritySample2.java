package com.ray.deepintothread.ch01.topic_16;

import java.util.Random;

public class PrioritySample2 {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			ThreadThree ThreadThree = new ThreadThree();
			ThreadThree.setName("high priority");
			ThreadThree.setPriority(2);
			ThreadThree.start();
			ThreadFour ThreadFour = new ThreadFour();
			ThreadFour.setName("low priority");
			ThreadFour.setPriority(1);
			ThreadFour.start();
		}
		Thread.sleep(2000);
		System.out.println("--------------");
		for (int i = 0; i < 5; i++) {
			ThreadThree ThreadThree = new ThreadThree();
			ThreadThree.setName("high priority");
			ThreadThree.setPriority(3);
			ThreadThree.start();
			ThreadFour ThreadFour = new ThreadFour();
			ThreadFour.setName("low priority");
			ThreadFour.setPriority(2);
			ThreadFour.start();
		}
		Thread.sleep(2000);
		System.out.println("--------------");
		for (int i = 0; i < 5; i++) {
			ThreadThree ThreadThree = new ThreadThree();
			ThreadThree.setName("high priority");
			ThreadThree.setPriority(6);
			ThreadThree.start();
			ThreadFour ThreadFour = new ThreadFour();
			ThreadFour.setName("low priority");
			ThreadFour.setPriority(5);
			ThreadFour.start();
		}
		Thread.sleep(2000);
		System.out.println("--------------");
		for (int i = 0; i < 5; i++) {
			ThreadThree ThreadThree = new ThreadThree();
			ThreadThree.setName("high priority");
			ThreadThree.setPriority(8);
			ThreadThree.start();
			ThreadFour ThreadFour = new ThreadFour();
			ThreadFour.setName("low priority");
			ThreadFour.setPriority(7);
			ThreadFour.start();
		}
		Thread.sleep(2000);
		System.out.println("--------------");
		for (int i = 0; i < 5; i++) {
			ThreadThree ThreadThree = new ThreadThree();
			ThreadThree.setName("high priority");
			ThreadThree.setPriority(10);
			ThreadThree.start();
			ThreadFour ThreadFour = new ThreadFour();
			ThreadFour.setName("low priority");
			ThreadFour.setPriority(1);
			ThreadFour.start();
		}
	}
}

class ThreadThree extends Thread {

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

class ThreadFour extends Thread {

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
