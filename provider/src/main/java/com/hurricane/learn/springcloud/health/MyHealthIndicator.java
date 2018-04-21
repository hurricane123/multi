package com.hurricane.learn.springcloud.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import com.hurricane.learn.springcloud.controller.StatusController;
@Component
public class MyHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		Builder builder = new Health.Builder();
		if (StatusController.status) {
			builder.status(Status.UP);
		}else {
			builder.status(Status.DOWN);
		}
		return builder.build();
	}

}
