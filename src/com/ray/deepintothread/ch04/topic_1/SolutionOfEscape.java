package com.ray.deepintothread.ch04.topic_1;

public class SolutionOfEscape {

	private int id = 0;
	private String name = null;

	Thread thread1 = null;
	Thread thread2 = null;

	public SolutionOfEscape() {
		thread1 = new Thread(new MyClass());
		thread2 = new Thread(new MyClass());
		name = "ray";
	}

	public void start() {
		thread1.start();
		thread2.start();
	}

	private class MyClass implements Runnable {
		@Override
		public void run() {

			System.out.println(SolutionOfEscape.this.name);
			System.out.println(SolutionOfEscape.this.id);

		}
	}

	public static void main(String[] args) {
		new SolutionOfEscape().start();
	}
}
