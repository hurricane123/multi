package com.hurricane.learn.springboot.web;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.function.BiConsumer;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;
import com.zaxxer.hikari.HikariConfig;

@SpringBootApplication
@ServletComponentScan
public class App {
	// springboot默认的数据源为com.zaxxer.hikari.HikariDataSource，通过下面的方式可以看到HikariDataSource数据源的配置
	static BiConsumer<String, DataSource> hikariPrint = (a, d) -> {
		try {
			Method method = HikariConfig.class.getDeclaredMethod("logConfiguration", null);
			method.setAccessible(true);
			method.invoke(d, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	static BiConsumer<String, DataSource> druidPrint = (a, d) -> {
		DruidDataSource dataSource = (DruidDataSource) d;
		System.out.println(a+"---"+dataSource.getInitialSize());
	};

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(App.class);
		application.setAdditionalProfiles("web");
		ConfigurableApplicationContext run = application.run(args);
		Map<String, DataSource> beansOfType = run
				.getBeansOfType(DataSource.class);

		
		 beansOfType.forEach(druidPrint);


//		 ConfigurableApplicationContext run = SpringApplication.run(App.class,
//		 args);
	}

	/**
	 * 只要MultipartResolver在classpath中，springboot就会初始化一个MultipartResolver的bean
	 */
	// @Bean
	// public MultipartResolver multipartResolver() {
	// CommonsMultipartResolver resolver = new CommonsMultipartResolver();
	// resolver.setMaxUploadSize(1024*1024*1);//100M
	// resolver.setDefaultEncoding("UTF-8");
	// resolver.setMaxInMemorySize(1024*10);//10K
	// // resolver.setResolveLazily(true);
	// return resolver;
	// }

	// @Bean
	// public MultipartConfigElement multipartConfigElement() {
	// MultipartConfigFactory factory = new MultipartConfigFactory();
	// factory.setMaxFileSize("100MB");
	// factory.setMaxRequestSize("100MB");
	// return factory.createMultipartConfig();
	// }

}
