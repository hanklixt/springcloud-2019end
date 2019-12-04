package com.hank.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker   //无论是feign,还是ribbon+restTemplate 要想获取熔断数据，都需要打开此注解
@EnableHystrixDashboard   //打开web界面，产看熔断信息
 public class OrderFeginApplication  {

	public static void main(String[] args) {
		SpringApplication.run(OrderFeginApplication.class,args);
	}


}
