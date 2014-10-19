package com.chf.sample.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class A {

	@Value("${id}")
	private int id;

	@Value("${str}")
	private String str;

	private String str2 = "str2";

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

	public String getStr2() {
		return str2;
	}

	public void setStr2(String str2) {
		this.str2 = str2;
	}

	protected void out() {
		System.out.println("default out.");
	}
}
