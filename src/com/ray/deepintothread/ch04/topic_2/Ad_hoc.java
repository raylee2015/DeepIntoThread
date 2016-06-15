package com.ray.deepintothread.ch04.topic_2;

public class Ad_hoc {

	private int id = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addId() {
		id++;
	}

	public static void main(String[] args) {
		Ad_hoc ad_hoc = new Ad_hoc();
		for (int i = 0; i < 10; i++) {
			ad_hoc.addId();
			System.out.println(ad_hoc.getId());
		}
		for (int i = 0; i < 10; i++) {
			ad_hoc.setId(i);
			System.out.println(ad_hoc.getId());
		}
	}
}
