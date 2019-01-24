package com.imooc.example.user.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(value = "order",path = "/api/ticket")
public interface OrderClient {
    @GetMapping(value = "")
    public String get();

    @GetMapping(value = "/{id}")
    public Map getId(@PathVariable(name = "id")Long id);
}
