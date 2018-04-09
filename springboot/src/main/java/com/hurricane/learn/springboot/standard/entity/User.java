package com.hurricane.learn.springboot.standard.entity;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 使用注解@ConfigurationProperties（需要配合@EnableConfigurationProperties或@SpringBootApplication使用），
 * 来自动将配置文件中的属性注入进去
 * @author Hurricane
 * @date 2018年4月8日
 * @version 1.0
 */
@ConfigurationProperties(prefix="user")
//@Component
public class User {
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}
	
	
}
