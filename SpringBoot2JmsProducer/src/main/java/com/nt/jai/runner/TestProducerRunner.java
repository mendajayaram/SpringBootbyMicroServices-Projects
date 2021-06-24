package com.nt.jai.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.jai.service.ProducerSevice;
@Component
public class TestProducerRunner implements CommandLineRunner {
	@Autowired
	private ProducerSevice ps;

	@Override
	public void run(String... args) throws Exception {
		ps.send("my-q1", "Hello Data Sample");
		System.out.println("SENT...");

	}

}
