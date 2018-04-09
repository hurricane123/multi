package com.hurricane.learn.springboot.standard.config.selector;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
@Component
public class LogSelector implements ImportSelector,BeanPostProcessor{
	private static final Logger logger = LoggerFactory.getLogger(LogSelector.class);
	private static String[] packages;
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		MultiValueMap<String, Object> allAnnotationAttributes = importingClassMetadata.getAllAnnotationAttributes("com.hurricane.learn.springboot.standard.config.annotation.EnableLog");
		List<Object> list = allAnnotationAttributes.get("packages");
		String[] object = (String[]) list.get(0);
		packages = object;
		return new String[]{"com.hurricane.learn.springboot.standard.entity.Product","com.hurricane.learn.springboot.standard.entity.User"};
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if (packages!=null)
			for (int i = 0; i < packages.length; i++) {
				if (bean.getClass().getName().startsWith(packages[i])) {
					logger.debug("bean:{} 初始化开始.",beanName);
				}
			}
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		if (packages!=null)
			for (int i = 0; i < packages.length; i++) {
				if (bean.getClass().getName().startsWith(packages[i])) {
					logger.debug("bean:{} 初始化结束.",beanName);
				}
			}
		return bean;
	}
	
	
}
