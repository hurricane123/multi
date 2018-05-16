package com.hurricane.learn.springboot.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.hurricane.learn.springboot.web.entity.User;

//@WebFilter("/*")
public class SecureFilter implements Filter{
	private static final Logger logger = LoggerFactory.getLogger(SecureFilter.class);
	@Autowired
	private User user;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		Object name = request.getParameter("username");
		Object password = request.getParameter("password");
		logger.debug("参数中用户名为{},密码为{}.",name,password);
		logger.debug("实例中用户名为{},密码为{}.",user.getUsername(),user.getPassword());
		if (!isAllowAccess(name,password)) {
			response.getWriter().println("权限不足");
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	
	private boolean isAllowAccess(Object name,Object password) {
		if (StringUtils.isEmpty(name)||StringUtils.isEmpty(password)) {
			return false;
		}
		if (name.equals(user.getUsername())&&password.equals(user.getPassword())) {
			return true;
		}
		return false;
	}
	
}
