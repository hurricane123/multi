package com.hurricane.learn.springboot.web.socket.servlet;

import java.util.HashSet;
import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 这种方式貌似只能在tomcat下部署时使用
 * @author Hurricane
 * @date 2018年8月3日
 * @version 1.0
 */
public class MySocketConfig implements ServerApplicationConfig {
	private static Logger logger = LoggerFactory.getLogger(MySocketConfig.class);
    @Override
    public Set<ServerEndpointConfig> getEndpointConfigs(
            Set<Class<? extends Endpoint>> scanned) {

        Set<ServerEndpointConfig> result = new HashSet<>();
        logger.info("所有配置扫描到的Socket接口：{}",scanned);

        return result;
    }


    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {
        // Deploy all WebSocket endpoints defined by annotations in the examples
        // web application. Filter out all others to avoid issues when running
        // tests on Gump
        logger.info("所有注解扫描到的Socket接口：{}",scanned);
        return scanned;
    }
}
