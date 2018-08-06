package com.hurricane.learn.springboot.web.socket.spring;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class SocketHandler implements WebSocketHandler{
	private static final Logger logger = LoggerFactory.getLogger(SocketHandler.class);
	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		logger.info("连接建立");
	}

	@Override
	public void handleMessage(WebSocketSession session,
			WebSocketMessage<?> message) throws Exception {
		logger.info("处理信息，信息为：{}",message);
		new Thread(()->{
			try {
				sendMessageToUser(session,"来自服务器："+message.getPayload()+"-1");
				Thread.sleep(3000);
				sendMessageToUser(session,"来自服务器："+message.getPayload()+"-2");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}).start();
	}

	@Override
	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		logger.info("处理传输异常");
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus closeStatus) throws Exception {
		logger.info("连接关闭");
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

	
	public void sendMessageToUser(WebSocketSession session, String message) throws IOException {
        if (session != null && session.isOpen()) {
        	logger.info("发送消息，session为：{}",session);
        	TextMessage msg = new TextMessage(message);
            session.sendMessage(msg);
        }else {
        	logger.info("发送消息，session为空");
		}
    }
}
