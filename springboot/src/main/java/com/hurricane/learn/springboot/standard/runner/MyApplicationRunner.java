package com.hurricane.learn.springboot.standard.runner;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
/**
 * 可以识别的参数格式为：--abc=def
 * @author Hurricane
 * @date 2018年4月8日
 * @version 1.0
 */
@Component
public class MyApplicationRunner implements ApplicationRunner{
	private static final Logger logger = LoggerFactory.getLogger(MyApplicationRunner.class);
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.debug("=====MyApplicationRunner 传入参数有：{}=====",args.getOptionNames());
		Iterator<String> iterator = args.getOptionNames().iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			logger.debug("=====MyApplicationRunner 参数名{}：参数值：{}=====",string,args.getOptionValues(string));
			
		}
	}

}
