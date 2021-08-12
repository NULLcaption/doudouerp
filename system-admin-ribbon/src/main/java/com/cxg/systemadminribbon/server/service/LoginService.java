package com.cxg.systemadminribbon.server.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "serviceError")
    public String loginService(String name) {
        return restTemplate.getForObject("http://SYSTEM-ADMIN-INFO/login?name="+name, String.class);
    }

    public String serviceError(String name){
        return "hi,"+name+",sorry,login service error 500!";
    }

}
