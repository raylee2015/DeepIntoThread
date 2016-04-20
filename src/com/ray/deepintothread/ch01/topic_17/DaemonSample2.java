package com.ray.deepintothread.ch01.topic_17;

public class DaemonSample2 {
	public static void main(String[] args) throws InterruptedException {
		ThreadFour threadFour = new ThreadFour();
		threadFour.start();
		ThreadTwo threadTwo = new ThreadTwo();
		threadTwo.setDaemon(true);
		threadTwo.start();
	}
}

class ThreadFour extends Thread {

	@Override
	public void run() {
		while (true) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class ThreadTwo extends Thread {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " start");
	}
}
