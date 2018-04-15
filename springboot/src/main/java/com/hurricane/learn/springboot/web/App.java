package com.hurricane.learn.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@ServletComponentScan
public class App {
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(App.class);
		application.setAdditionalProfiles("web");
		application.run(args);
//		ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
	}
}
