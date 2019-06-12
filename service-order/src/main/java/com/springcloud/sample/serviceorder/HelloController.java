package com.springcloud.sample.serviceorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {

    @Autowired
    UserClient userClient;

    @GetMapping("hello")
    public String hello() {
        return "hello, this is order service";
    }

    @GetMapping("userHello")
    public String user() {
        return userClient.getUserHello() + ", this is order-service";
    }
}
