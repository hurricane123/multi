package com.hurricane.learn.springboot.standard.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * 程序添加运行参数--spring.profiles.active=dep
 * 来激活UserDaoDep的实例化
 * @author Hurricane
 * @date 2018年4月8日
 * @version 1.0
 */
@Profile("dep")
@Component
public class UserDaoDep implements UserDao{

}
