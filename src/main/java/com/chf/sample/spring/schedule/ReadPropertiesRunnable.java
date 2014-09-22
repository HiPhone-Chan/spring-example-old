package com.chf.sample.spring.schedule;

public class ReadPropertiesRunnable implements Runnable {

	public void run() {
		try {
			String key = "test";
			System.out.println(key);
			return;
		} catch (Exception e) {
			System.err.println("Exception:" + e.getMessage());
		}
	}
}
