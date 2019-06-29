package com.springcloud.sample.serviceorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
@RefreshScope // 加了这个注解才能动态刷新
public class HelloController {

    @Autowired
    UserClient userClient;

    @Value("${refreshedVal}")
    private String refreshedVal;

    @Value("${refreshedToggle:false}")
    private String refreshedToggle;

    @GetMapping("hello")
    public String hello() {
        return "hello, this is order service";
    }

    @GetMapping("refreshedProperty")
    public String refreshedProperty() {
        return String.format("refreshedVal: %s, refreshedToggle: %s",
                refreshedVal, refreshedToggle);
    }

    @GetMapping("userHello")
    public String user() {
        return userClient.getUserHello() + ", this is order-service";
    }
}
