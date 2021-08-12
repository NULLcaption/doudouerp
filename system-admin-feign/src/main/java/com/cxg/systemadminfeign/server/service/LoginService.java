package com.cxg.systemadminfeign.server.service;

import com.cxg.systemadminfeign.core.error.ServiceHystrixInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign添加hystrix熔断机制
 */
@FeignClient(value = "SYSTEM-ADMIN-INFO", fallback = ServiceHystrixInfo.class)
public interface LoginService {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    String getLoginAdminInfo(@RequestParam(value = "name") String name);
}
