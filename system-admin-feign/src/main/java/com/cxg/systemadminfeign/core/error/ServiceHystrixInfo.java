package com.cxg.systemadminfeign.core.error;

import com.cxg.systemadminfeign.server.service.LoginService;
import org.springframework.stereotype.Component;

@Component
public class ServiceHystrixInfo implements LoginService {

    @Override
    public String getLoginAdminInfo(String name) {
        return "sorry "+ name + "login service 500 error";
    }
}
