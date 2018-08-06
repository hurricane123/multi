package com.hurricane.learn.springboot.web.socket.spring;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

@Component
public class SocketInterceptor implements HandshakeInterceptor{

	private static final Logger logger = LoggerFactory.getLogger(SocketInterceptor.class);
	
	@Override
	public void afterHandshake(ServerHttpRequest arg0, ServerHttpResponse arg1,
			WebSocketHandler arg2, Exception arg3) {
		logger.info("===================afterHandshake===================");
	}

	@Override
	public boolean beforeHandshake(ServerHttpRequest request,
			ServerHttpResponse arg1, WebSocketHandler arg2,
			Map<String, Object> arg3) throws Exception {
		logger.info("===================beforeHandshake===================");
		if (request instanceof HttpServletRequest) {
			HttpServletRequest req = (HttpServletRequest) request;
			String type = req.getParameter("type");
			if ("abc".equals(type)) {
				logger.info("处理socket连接");
				return true;
			}else {
				logger.info("放弃socket连接");
			}
		}else {
			logger.info(request.getClass().toString());
		}
		return true;
	}

}
