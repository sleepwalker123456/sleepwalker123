package com.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @EnableEurekaClient：
 * 基于spring-cloud-netflix，服务注册中心只能是Eureka
 *
 * @EnableDiscoveryClient：
 * 基于spring-cloud-common，服务注册中心可以不是Eureka
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
@RestController
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class,args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam String name){
        System.out.println(name);
        return "hi " + name + ", I am from port: " + port;
    }

}
