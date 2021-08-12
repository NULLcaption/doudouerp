package com.cxg.systemadminribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * ribbon负载均衡中心
 * ribbon是一个负载均衡客户端，可以很好的控制http和tcp的一些行为。Feign默认集成了ribbon
 * Spring Cloud Ribbon 是一个基于Http和TCP的客服端负载均衡工具，它是基于Netflix Ribbon实现的。
 * 它不像服务注册中心、配置中心、API网关那样独立部署，但是它几乎存在于每个微服务的基础设施中。
 * 包括前面的提供的声明式服务调用也是基于该Ribbon实现的。
 * 第一步选择Eureka Server，它优先选择在同一个Zone且负载较少的Server；
 * 第二步再根据用户指定的策略，再从Server取到的服务注册列表中选择一个地址。
 * 其中Ribbon提供了很多策略，例如轮询round robin、随机Random、根据响应时间加权等。
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@ComponentScan(basePackages={"com.cxg.systemadminribbon.*"})
@EnableHystrix //熔断器
public class SystemAdminRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemAdminRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
