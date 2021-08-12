package com.cxg.systemadmininfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 系统管理管理端
 */
@SpringBootApplication
@EnableEurekaClient
public class SystemAdminInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemAdminInfoApplication.class, args);
    }

}
