package com.chf.sample.spring.controller.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/integration")
public class IntegrationController {

	@Autowired
	@Qualifier("inputChannel")
	private MessageChannel inputChannel;

	@Autowired
	@Qualifier("outputChannel")
	private PollableChannel outputChannel;

	@RequestMapping(path = "/{msg}", method = RequestMethod.GET)
	public String req(@PathVariable String msg) {
		inputChannel.send(new GenericMessage<String>(msg));
		String payload = (String) outputChannel.receive(0).getPayload();

		return payload;

	}

}
