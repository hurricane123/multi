package com.hurricane.learn.springboot.standard.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
/**
 * 程序添加运行参数--spring.profiles.active=dev
 * 来激活UserDaoDev的实例化
 * @author Hurricane
 * @date 2018年4月8日
 * @version 1.0
 */
@Profile("dev")
@Component
public class UserDaoDev implements UserDao{

}
