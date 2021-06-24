package com.nt.jai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
@Component
public class ProducerSevice {
@Autowired
	private JmsTemplate jt;
public void send(String destination,String message) {
	jt.send(destination,(ses)->ses.createTextMessage(message));
}
}
