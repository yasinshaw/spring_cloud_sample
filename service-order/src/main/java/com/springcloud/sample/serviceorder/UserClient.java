package com.springcloud.sample.serviceorder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service-user")
public interface UserClient {
    @GetMapping("hello")
    String getUserHello();
}
