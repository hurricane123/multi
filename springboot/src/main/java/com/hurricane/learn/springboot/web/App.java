package com.hurricane.learn.springboot.web;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;

@SpringBootApplication
@ServletComponentScan
public class App {
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(App.class);
		application.setAdditionalProfiles("web");
		ConfigurableApplicationContext run = application.run(args);
//		MultipartConfigElement bean = run.getBean(MultipartConfigElement.class);
//		System.out.println(bean.getMaxFileSize());
//		System.out.println(bean.getMaxRequestSize());
		
//		ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
	}
	
	/**
	 * 只要MultipartResolver在classpath中，springboot就会初始化一个MultipartResolver的bean
	 */
//	@Bean
//	public MultipartResolver multipartResolver() {
//		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//		resolver.setMaxUploadSize(1024*1024*1);//100M
//		resolver.setDefaultEncoding("UTF-8");
//		resolver.setMaxInMemorySize(1024*10);//10K
////		resolver.setResolveLazily(true);
//		return resolver;
//	}
	
//	@Bean
//    public MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setMaxFileSize("100MB"); 
//        factory.setMaxRequestSize("100MB");
//        return factory.createMultipartConfig();
//    }

}
