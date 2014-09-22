package com.chf.sample.other.email;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SimpleEmailMain {

	public static void main(String[] args) {
		String from = "chenhaifeng1@huawei.com";
		
		String sender = "chenhaifeng1@huawei.com";
		String password = "12!chhfeng";

		String receiver = "chenhaifeng1@huawei.com";
		String hostName = "10.82.71.56";
		String content = "~~~~~~~~hi";
		String subject = "title";

		SimpleEmail simpleEmailSender = new SimpleEmail();
		try {
			simpleEmailSender.setFrom(from);
			simpleEmailSender.setAuthentication(sender, password);
			simpleEmailSender.setCharset("UTF-8");
			simpleEmailSender.setHostName(hostName);
			simpleEmailSender.addTo(receiver);
			simpleEmailSender.setMsg(content);
			simpleEmailSender.setSubject(subject);
			simpleEmailSender.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
		System.out.println("ok");
	}

}
