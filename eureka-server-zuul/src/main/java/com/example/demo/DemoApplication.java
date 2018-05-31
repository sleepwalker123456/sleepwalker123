package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @EnableZuulProxy开启Zuul功能，可以简单理解为@EnableZuulServer的加强版。
 * 当Zuul与Ribbon，Eureka等组件组合使用时，使用@EnableZuulProxy。
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy //开启Zuul功能
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
