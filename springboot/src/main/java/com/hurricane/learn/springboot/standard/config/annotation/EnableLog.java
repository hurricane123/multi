package com.hurricane.learn.springboot.standard.config.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.hurricane.learn.springboot.standard.config.selector.LogSelector;


/**
 * 打印指定包下，注入的spring容器中的bean
 * @author Hurricane
 * @date 2018年4月9日
 * @version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(LogSelector.class)
public @interface EnableLog {
	
	String[] packages();

}
