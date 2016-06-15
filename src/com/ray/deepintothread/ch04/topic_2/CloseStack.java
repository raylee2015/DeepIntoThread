package com.ray.deepintothread.ch04.topic_2;

import java.util.HashSet;

public class CloseStack extends Thread{

	public static void test() {
		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < 10; i++) {
			set.add(i + "");
		}
	}
	
	@Override
	public void run() {
		test();
	}

	public static void main(String[] args) {
		new CloseStack().start();
		new CloseStack().start();
		new CloseStack().start();
	}
}
