package com.cxg.systemadmininfo.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统管理登录
 */
@RestController
public class LoginController {

    @RequestMapping("/login")
    public String getSystemInfo(@RequestParam(value = "name") String name){
        return "hello system admin " + name;
    }
}
