package com.springcloud.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
@RequestMapping
public class RefreshController {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 远程 git webhooks ，调用此接口，由此接口发起 http post 请求去
     * 触发bus-refresh 接口，通过 rabbitmq 等一系列 默认处理机制就可以实现动态刷新机制
     *
     * @throws IOException
     */
    @PostMapping("myRefresh")
    public void httpPostJSON() throws IOException {
        // 模拟 http 请求
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        HttpEntity<String> entity = new HttpEntity<String>(null,headers);
        String result = restTemplate.postForObject("http://localhost:8080/actuator/bus-refresh", entity, String.class);
    }
}
