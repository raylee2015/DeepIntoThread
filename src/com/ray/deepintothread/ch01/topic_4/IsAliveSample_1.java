package com.ray.deepintothread.ch01.topic_4;

public class IsAliveSample_1 {
	public static void main(String[] args) {
		ThreadFive threadFive = new ThreadFive();
		Thread thread = new Thread(threadFive);
		System.out.println("Thread name:" + Thread.currentThread().getName());
		System.out.println("Thread isAlive:" + Thread.currentThread().isAlive());
		thread.setName("myThread");// ���������̵߳�����
		threadFive.setName("threadFive");// ����ʵ��������
		threadFive.myTest();
		thread.start();
	}
}

class ThreadFive extends Thread {
	public void myTest() {
		show();
	}

	private void show() {
		System.out.println("----------begin----------");
		// ����ָ����ִ������̵߳�����
		System.out.println("Thread name:" + Thread.currentThread().getName());
		System.out.println("Thread isAlive:" + Thread.currentThread().isAlive());
		// this.getNameָ�������ʵ��������
		// �����Ǽ̳�Thread��Thread���������������
		System.out.println("Instance name:" + this.getName());
		System.out.println("Instance isAlive:" + this.isAlive());
		System.out.println("----------end----------");
	}

	@Override
	public void run() {
		super.run();
		show();
	}
}