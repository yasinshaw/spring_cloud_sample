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

    @Autowired
    RestTemplate restTemplate;

    @Value("${refreshedVal}")
    private String refreshedVal;

    @GetMapping("hello")
    public String hello() {
        return "hello, this is order service";
    }

    @GetMapping("refreshedVal")
    public String refreshedVal() {
        return "order service refreshedVal: " + refreshedVal;
    }

    @GetMapping("userHello")
    public String user() {
        return userClient.getUserHello() + ", this is order-service";
    }

    @GetMapping("/ribbon/service-user")
    public String ribbonService(){
        return restTemplate.getForObject("http://service-user/hello", String.class);
    }
}
