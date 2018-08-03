package com.hurricane.learn.springboot.web.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.alibaba.druid.pool.DruidDataSource;

@ConfigurationProperties("spring.datasource.druid")
public class DruidDataSourceWrapper extends DruidDataSource implements InitializingBean {
	private static final long serialVersionUID = 1028748796947256521L;
	
	@Autowired
	private DataSourceProperties basicProperties;

	@Override
	public void afterPropertiesSet() throws Exception {
		//if not found prefix 'spring.datasource.druid' jdbc properties ,'spring.datasource' prefix jdbc properties will be used.
		System.out.println("============afterPropertiesSet============");
		System.out.println(getUsername()+"---"+getPassword()+"---"+getUrl()+"---"+getDriverClassName());
		if (super.getUsername() == null) {
			super.setUsername(basicProperties.determineUsername());
		}
		if (super.getPassword() == null) {
			super.setPassword(basicProperties.determinePassword());
		}
		if (super.getUrl() == null) {
			super.setUrl(basicProperties.determineUrl());
		}
		if(super.getDriverClassName() == null){
			super.setDriverClassName(basicProperties.getDriverClassName());
		}

	}

}
