package com.cxg.systemadminribbon.server.controller;

import com.cxg.systemadminribbon.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    @ResponseBody
    private String login(@RequestParam String name){
        return loginService.loginService(name);
    }
}
