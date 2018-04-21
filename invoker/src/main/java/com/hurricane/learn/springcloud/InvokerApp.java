package com.hurricane.learn.springcloud;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class InvokerApp {
	
	@Bean
	@LoadBalanced
	public RestTemplate createRestTemplate() {
		return new RestTemplate();
	}
	
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(
				InvokerApp.class, args);
	}
}
