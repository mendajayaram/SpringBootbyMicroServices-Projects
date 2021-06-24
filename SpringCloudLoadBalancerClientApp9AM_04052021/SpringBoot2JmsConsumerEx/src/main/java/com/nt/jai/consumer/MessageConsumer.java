package com.nt.jai.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
	@JmsListener(destination = "my-q1")
	public void readMessage(String message) {
		System.out.println("At Consumer!" + message);
	}
}