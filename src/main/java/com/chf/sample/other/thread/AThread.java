package com.chf.sample.other.thread;

public class AThread extends Thread {

	private String str;

	public AThread(String str) {
		this.str = str;
	}

	public void run() {
		try {
			while (true) {
				Thread.sleep(5000);
				System.out.println("hi~~~" + str);

				if ("1".equals(str)) {
					break;
				}
			}
			System.out.println("Thread " + str + "end.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
