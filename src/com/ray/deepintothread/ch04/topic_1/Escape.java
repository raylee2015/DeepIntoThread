package com.ray.deepintothread.ch04.topic_1;

public class Escape {

	private int id = 0;
	private String name = null;

	public Escape() {
		new Thread(new MyClass()).start();
		new Thread(new MyClass()).start();
		name = "ray";
	}

	private class MyClass implements Runnable {
		@Override
		public void run() {

			System.out.println(Escape.this.name);
			System.out.println(Escape.this.id);

		}
	}

	public static void main(String[] args) {
		new Escape();
	}
}
