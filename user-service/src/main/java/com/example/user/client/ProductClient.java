package com.example.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// 👇 "product-service" is the name registered in Eureka
@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/hello")
    String getProductHello();
}
