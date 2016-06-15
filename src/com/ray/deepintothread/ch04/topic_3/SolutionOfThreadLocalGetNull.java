package com.ray.deepintothread.ch04.topic_3;

public class SolutionOfThreadLocalGetNull {

	private int count = 0;

	public ThreadLocal<Integer> intThreadLocal = new ThreadLocal<Integer>() {
		// 解决办法就是初始化数值
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
