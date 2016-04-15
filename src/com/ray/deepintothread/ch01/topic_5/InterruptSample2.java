package com.ray.deepintothread.ch01.topic_5;

public class InterruptSample2 {
	public static void main(String[] args) {
		System.out.println("--------------------------");
		Thread.currentThread().interrupt();
		System.out.println(Thread.interrupted());
		System.out.println(Thread.interrupted());
		System.out.println(Thread.currentThread().isInterrupted());
		System.out.println(Thread.currentThread().isInterrupted());
		System.out.println("--------------------------");
		Thread.currentThread().interrupt();
		System.out.println(Thread.currentThread().isInterrupted());
		System.out.println(Thread.currentThread().isInterrupted());
		System.out.println("--------------------------");
		Thread.currentThread().interrupt();
		System.out.println(Thread.interrupted());
		System.out.println(Thread.interrupted());
	}
}
