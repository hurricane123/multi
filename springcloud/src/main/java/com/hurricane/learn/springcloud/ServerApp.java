package com.hurricane.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaServer
public class ServerApp {
	
	public static void main(String[] args) {
//		SpringApplication application = new SpringApplicationBuilder(ServerApp.class).web(true).build();
//		application.run(args);
		ConfigurableApplicationContext run = SpringApplication.run(ServerApp.class, args);
	}
}
