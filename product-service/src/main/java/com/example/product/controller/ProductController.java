package com.example.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/hello")
    public String hello() {
        return "Product Service says: Hello from Config Server to Product Service!";
    }
}
