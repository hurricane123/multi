package com.hurricane.learn.springcloud.ribbon;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;

public class MyRule extends RoundRobinRule{

	private Random random = new Random(System.currentTimeMillis());
	
	/**
	 * 让一半的请求被第一个server处理，剩余的请求被轮询
	 */
	@Override
	public Server choose(Object key) {
		List<Server> allServers = getLoadBalancer().getAllServers();
		List<Server> reachableServers = getLoadBalancer().getReachableServers();
		System.out.println("all:"+allServers);
		System.out.println("reacheable:"+reachableServers);
		int nextInt = random.nextInt(100);
		if (nextInt>50) {
			System.out.println("choose 0");
			return allServers.get(0);
		}
		return super.choose(key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}

}
