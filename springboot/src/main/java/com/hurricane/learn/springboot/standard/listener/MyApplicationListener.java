package com.hurricane.learn.springboot.standard.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
/**
 * 使用方式有两种，分别为：<br/>
 * 1.application.addListeners(new MyApplicationListener());
 * 2.org.springframework.context.ApplicationListener=com.hurricane.learn.springboot.listener.MyApplicationListener
 * @author Hurricane
 * @date 2018年4月8日
 * @version 1.0
 */
public class MyApplicationListener implements ApplicationListener<ContextClosedEvent>{
	private static final Logger logger = LoggerFactory.getLogger(MyApplicationListener.class);
	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		logger.debug("=======event为：{}=========",event);
	}

}
