package com.springcloud.sample.serviceuser;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {

    @Value("${spring.cloud.consul.discovery.instanceId}")
    private String instanceId;

    @GetMapping("hello")
    public String hello() {
        return String.format("hello, this is %s", instanceId);
    }
}
