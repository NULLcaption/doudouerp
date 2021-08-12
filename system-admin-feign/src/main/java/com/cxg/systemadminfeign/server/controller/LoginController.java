package com.cxg.systemadminfeign.server.controller;

import com.cxg.systemadminfeign.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @SuppressWarnings("all")
    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String login(@RequestParam String name){
        return loginService.getLoginAdminInfo(name);
    }
}
