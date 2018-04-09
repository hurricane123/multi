package com.hurricane.learn.springboot.standard;

import java.util.Arrays;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.hurricane.learn.springboot.standard.config.annotation.EnableLog;
import com.hurricane.learn.springboot.standard.config.selector.LogSelector;
import com.hurricane.learn.springboot.standard.dao.UserDao;
import com.hurricane.learn.springboot.standard.entity.Product;
import com.hurricane.learn.springboot.standard.event.MyEvent;

/**
 * 参考手册https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/
 * 注解@Import会把value指定的class导入到spring容器中，但是如果指定的class实现了ImportSelector接口，
 * 则不会将自身导入到spring容器中，但是ImportSelector接口中selectImports方法返回的值（类的全路径）会导入到spring容器中
 * @author Hurricane
 * @date 2018年4月8日
 * @version 1.0
 */
//@Import(LogSelector.class)
@EnableLog(packages="com.hurricane")
@SpringBootApplication
public class App {
	
	
	public static void main(String[] args) {
//		SpringApplication application = new SpringApplication(App.class);
//		ConfigurableApplicationContext context = application.run(args);
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
//		Runnable bean = context.getBean(Runnable.class);
//		User bean = context.getBean(User.class);
//		Product bean = context.getBean(Product.class);
		LogSelector bean = context.getBean(LogSelector.class);
		System.out.println(bean);
		String[] beanNamesForType = context.getBeanNamesForType(Product.class);
		System.out.println(Arrays.asList(beanNamesForType));
		Map<String, UserDao> beansOfType = context.getBeansOfType(UserDao.class);
		System.out.println(beansOfType);
		
		context.publishEvent(new MyEvent("myevent"));
		context.close();
	}
//	@Bean
//	public Runnable createRunnable() {
//		return ()->{};
//	}
//	@Bean
//	public User createUser() {
//		return new User();
//	}
	
}
