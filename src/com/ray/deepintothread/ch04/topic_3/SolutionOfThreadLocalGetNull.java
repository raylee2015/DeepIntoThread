package com.ray.deepintothread.ch04.topic_3;

public class SolutionOfThreadLocalGetNull {

	private int count = 0;

	public ThreadLocal<Integer> intThreadLocal = new ThreadLocal<Integer>() {
		// ����취���ǳ�ʼ����ֵ
		@Override
		protected Integer initialValue() {
			return count;
		}
	};

	public int getCount() {
		return intThreadLocal.get();
	}

	public void addCount() {
		intThreadLocal.set(count++);
	}

	public static void main(String[] args) {
		System.out.println(new SolutionOfThreadLocalGetNull().getCount());
	}
}
