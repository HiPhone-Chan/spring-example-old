package com.chf.sample.other.ssh;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

public class UserAuthKI {

	public static void main(String[] arg) {

		String user = "root";
		String host = "10.137.151.200";
		int port = 22;

		try {
			JSch jsch = new JSch();

			Session session = jsch.getSession(user, host, port);

			// username and passphrase will be given via UserInfo interface.
			UserInfo ui = new MyUserInfo();
			session.setUserInfo(ui);
			session.connect();

			Channel channel = session.openChannel("shell");

			channel.setInputStream(System.in);
			channel.setOutputStream(System.out);
			channel.connect();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
