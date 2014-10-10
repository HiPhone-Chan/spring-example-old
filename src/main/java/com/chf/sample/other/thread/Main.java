package com.chf.sample.other.thread;

public class Main {
	public static void main(String[] args) {
		Thread thread = new AThread("1");
//		Thread thread2 = new AThread("2");
//
//		thread2.setDaemon(true);
//		
//		thread.start();
//		thread2.start();
		
		thread.run();
		System.out.println("main end.");
	}
}
