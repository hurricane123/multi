package com.hurricane.learn.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class ClientController {
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	private RestTemplate template;

	
	@GetMapping(value="/invoke")
	public Object invoke() {
		String user = template.getForObject("http://user-service-provider/getUser", String.class);
		return user;
	}
	
	
}
