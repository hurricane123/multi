package com.hurricane.learn.springboot.standard.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
/**
 * 可以识别的参数格式为：--abc=def
 * @author Hurricane
 * @date 2018年4月8日
 * @version 1.0
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner{
	private static final Logger logger = LoggerFactory.getLogger(MyCommandLineRunner.class);
	@Override
	public void run(String... args) throws Exception {
		logger.debug("=====MyCommandLineRunner 传入参数有：{}=====",args);
	}

}
