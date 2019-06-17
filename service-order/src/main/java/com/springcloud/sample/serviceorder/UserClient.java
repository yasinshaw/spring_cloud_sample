package com.springcloud.sample.serviceorder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "service-user", fallback = UserClientImpl.class)
public interface UserClient {
    @GetMapping("hello")
    String getUserHello();
}
