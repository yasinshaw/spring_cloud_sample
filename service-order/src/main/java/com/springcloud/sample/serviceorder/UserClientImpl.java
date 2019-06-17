package com.springcloud.sample.serviceorder;

import org.springframework.stereotype.Component;

@Component
public class UserClientImpl implements UserClient {
    @Override
    public String getUserHello() {
        return "empty user";
    }
}
