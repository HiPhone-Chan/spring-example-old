package com.chf.sample.spring.controller.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chf.sample.domain.Greeting;
import com.chf.sample.domain.HelloMessage;

@Controller
public class SocketController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(3000); // simulated delay
		return new Greeting("Hello, " + message.getName() + "!");
	}

	@RequestMapping(value = "socket", method = RequestMethod.GET)
	public String toSocketPage() {
		return "socket";
	}
}
