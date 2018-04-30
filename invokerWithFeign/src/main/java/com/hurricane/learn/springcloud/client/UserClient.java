package com.hurricane.learn.springcloud.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hurricane.learn.springcloud.entity.User;
import com.netflix.client.http.HttpRequest;

@FeignClient("user-service-provider")
@Component
public interface UserClient {
	
	@RequestMapping(value="/getUser",method=RequestMethod.GET)
	User getUser();
	
}
