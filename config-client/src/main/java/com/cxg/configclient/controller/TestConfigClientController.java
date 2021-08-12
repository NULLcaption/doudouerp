package com.cxg.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestConfigClientController {

    @Value("${dou.dou.erp}")
    private String foo;

    @Value("${demo.config.client.message}")
    private String mags;

    @RequestMapping(value = "/getfoo")
    public String getFoo(){
        return foo + ": " +mags;
    }
}
