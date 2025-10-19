package com.example.aggregator.controller;

import com.example.aggregator.dto.UserProductResponseDTO;
import com.example.aggregator.service.AggregatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AggregatorController {

    private final AggregatorService aggregatorService;

    public AggregatorController(AggregatorService aggregatorService) {
        this.aggregatorService = aggregatorService;
    }

    @GetMapping("/user-product/{userId}")
    public UserProductResponseDTO getUserProduct(@PathVariable Long userId) {
        return aggregatorService.getUserWithProductMessage(userId);
    }
}
