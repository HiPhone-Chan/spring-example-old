package com.chf.sample.other.ssh;

import java.util.Scanner;

import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;

public class MyUserInfo implements UserInfo, UIKeyboardInteractive {

	private String passwd = "huawei";

	private Scanner sc = new Scanner(System.in);;

	public String getPassword() {
		return passwd;
	}

	public boolean promptYesNo(String str) {
		System.out.println(str);
		System.out.println("Input y for yes, other input for no.");
		String ans = sc.next();

		if ("y".equals(ans)) {
			return true;
		}
		return false;
	}

	public String getPassphrase() {
		return null;
	}

	public boolean promptPassphrase(String message) {
		return false;
	}

	public boolean promptPassword(String message) {
		System.out.println(message);

		String password = sc.next();

		if (password == null || password.equals("")) {
			return false;
		}
		return true;
	}

	public void showMessage(String message) {
		System.out.println(message);
	}

	public String[] promptKeyboardInteractive(String destination, String name,
			String instruction, String[] prompt, boolean[] echo) {

		System.out.println("promptKeyboardInteractive");
		System.out.println("destination: " + destination);
		System.out.println("name: " + name);
		System.out.println("instruction: " + instruction);
		System.out.println("prompt.length: " + prompt.length);
		System.out.println("prompt: " + prompt[0]);

		String[] response = new String[prompt.length];
		for (int i = 0; i < prompt.length; i++) {
			response[i] = sc.next();
		}
		return response;
	}

}
