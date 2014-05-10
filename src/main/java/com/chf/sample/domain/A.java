package com.chf.sample.domain;

public class A {
	private int id;
	private String str;

	public A() {
	}

	public A(int id, String str) {
		this.id = id;
		this.str = str;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	protected void out() {
		System.out.println("default out.");
	}
}
