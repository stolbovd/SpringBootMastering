package ru.inkontext.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ru.inkontext.aop.TaskAspect;

@Configuration
public class StarterConfig {

	@Bean
	TaskAspect taskAspect() {
		return new TaskAspect();
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}
}
