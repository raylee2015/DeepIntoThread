package com.ray.deepintothread.ch02.topic_19;

/**
 * 
 * @author RayLee
 *
 */
public class MonitorOfSynch2 {
	public static void main(String[] args) throws InterruptedException {
		MyService2 myService = new MyService2();
		ThreadThree threadThree = new ThreadThree(myService);
		Thread thread = new Thread(threadThree);
		thread.setName("thread A");
		thread.start();
		ThreadFour threadFour = new ThreadFour(myService);
		Thread thread2 = new Thread(threadFour);
		thread2.setName("thread B");
		thread2.start();
	}
}

class ThreadThree implements Runnable {

	private MyService2 myService;

	public ThreadThree(MyService2 myService) {
		this.myService = myService;
	}

	@Override
	public void run() {
		try {
			myService.updateA();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadFour implements Runnable {

	private MyService2 myService;

	public ThreadFour(MyService2 myService) {
		this.myService = myService;
	}

	@Override
	public void run() {
		try {
			myService.updateB();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyService2 {

	private Person person = new Person();

	public void updateA() throws InterruptedException {
		synchronized (person) {
			for (int i = 0; i < 5; i++) {
				System.out.println("person name:" + person.getName());
				// 设置新的属性
				person.setId(i);
				person.setName(person.getName() + "-" + i);
				System.out.println(Thread.currentThread().getName() + " " + person.getName());
				Thread.sleep(50);
				// 复原对象
				person.setId(0);
				person.setName("ray");
				System.out.println("-------------------");
			}
		}
	}

	public void updateB() throws InterruptedException {
		synchronized (person) {
			for (int i = 0; i < 5; i++) {
				System.out.println("person name:" + person.getName());
				// 设置新的属性
				person.setId(i);
				person.setName(person.getName() + "-" + i);
				System.out.println(Thread.currentThread().getName() + " " + person.getName());
				Thread.sleep(100);
				// 复原对象
				person.setId(0);
				person.setName("ray");
				System.out.println("-------------------");
			}
		}
	}

}

/**
 * 自有对象
 * 
 * @author R
 *
 */
class Person {
	private int id = 0;
	private String name = "ray";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
