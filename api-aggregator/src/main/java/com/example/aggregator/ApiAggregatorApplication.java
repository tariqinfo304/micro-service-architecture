package com.example.aggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiAggregatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiAggregatorApplication.class, args);
    }
}
