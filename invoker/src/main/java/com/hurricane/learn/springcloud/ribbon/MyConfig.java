package com.hurricane.learn.springcloud.ribbon;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

//@RibbonClient(name="user-service-provider",configuration=MyConfig.class)
public class MyConfig {
	
	@Bean
	public MyRule createMyRule() {
		return new MyRule();
	}

}
