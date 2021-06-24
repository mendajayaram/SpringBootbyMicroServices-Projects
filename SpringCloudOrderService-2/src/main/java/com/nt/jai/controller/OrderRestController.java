package com.nt.jai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.jai.consumer.VendorRestConsumer;
@RestController
@RequestMapping("/order")
public class OrderRestController {

	@Autowired
	private VendorRestConsumer consumer;//HAS-A
	
	@GetMapping("/info")
	public String getOrderInfo() {
		return "FROM ORDER and " + consumer.getVendorData();
	}
}
