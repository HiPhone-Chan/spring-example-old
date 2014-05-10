package com.chf.sample.domain;

import org.springframework.stereotype.Component;

@Component
public class A1 extends A {

	private int a1Id;

	public A1() {

	}

	public A1(int id, String str) {
		super(id, str);
	}

	public int getA1Id() {
		return a1Id;
	}

	public void setA1Id(int a1Id) {
		this.a1Id = a1Id;
	}

}
