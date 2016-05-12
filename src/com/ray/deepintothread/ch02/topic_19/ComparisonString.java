package com.ray.deepintothread.ch02.topic_19;

public class ComparisonString {
	public static void main(String[] args) {
		String a = "a";
		String b = "a";
		System.out.println(a == b);
		String c = new String("a");
		String d = new String("a");
		System.out.println(c == d);
	}
}
