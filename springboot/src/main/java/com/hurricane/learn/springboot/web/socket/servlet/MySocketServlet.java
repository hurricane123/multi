package com.hurricane.learn.springboot.web.socket.servlet;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 这种方式只有放置到tomcat下部署，才能生效
 * @author Hurricane
 * @date 2018年8月6日
 * @version 1.0
 */
@ServerEndpoint("/socketPoint")
public class MySocketServlet{
	private static Logger logger = LoggerFactory.getLogger(MySocketServlet.class);


	@OnOpen
	public void start(Session session) {
		System.out.println(this);
		logger.info("服务器：连接打开");
	}


	@OnClose
	public void end() {
		logger.info("服务器：连接关闭");
	}


	@OnMessage
	public void incoming(Session session, String msg, boolean last) {
		// Never trust the client
		logger.info("服务器：接收到消息：{}",msg);
		try {
			session.getBasicRemote().sendText("来自服务器的响应："+msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@OnError
	public void onError(Throwable t) throws Throwable {
		logger.info("连接错误：{}",t.getStackTrace());
	}
}
