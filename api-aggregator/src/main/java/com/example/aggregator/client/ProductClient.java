package com.example.aggregator.client;

import com.example.aggregator.dto.ProductMessageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/hello")
    ProductMessageDTO getProductMessage();
}
