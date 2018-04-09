package com.hurricane.learn.springboot.standard.initializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
/**
 * 因为这个类的initialize方法调用是在spring容器中的bean还没有开始初始化的时刻，
 * 因此，通过@Component注解是无法使其生效的。<br/>
 * 使用方式有两种，分别为：<br/>
 * 1.application.addInitializers(new MyApplicationContextInitializer());
 * 2.org.springframework.context.ApplicationContextInitializer=com.hurricane.learn.springboot.initializer.MyApplicationContextInitializer
 * @author Hurricane
 * @date 2018年4月8日
 * @version 1.0
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{
	private static final Logger logger = LoggerFactory.getLogger(MyApplicationContextInitializer.class);
	@Override
	public void initialize(ConfigurableApplicationContext context) {
		logger.debug("========MyApplicationContextInitializer initialize=============");
	}

}
