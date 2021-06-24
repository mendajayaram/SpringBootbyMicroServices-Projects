package com.nt.jai.consumer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VendorRestConsumer {
	// 1. Autowire the discovery client
	@Autowired
	private DiscoveryClient client;

	// define one operation for find/bind process
	public String getVendorData() {
		// goto eureka with ServiceId and get List of ServiceInstances
		List<ServiceInstance> list = client.getInstances("VENDOR-SERVICE");

		// read for serviceInstance at index#0 (as we have oneinstance now)
		ServiceInstance si = list.get(0);
		// read URI and add Path
		String url = si.getUri() + "/vendor/msg";
		// use RestTemplate
		RestTemplate rt = new RestTemplate();
		// make call and get Response
		ResponseEntity<String> resp = rt.getForEntity(url, String.class);
		// return response body
		return resp.getBody();
	}

}
