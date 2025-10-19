package com.example.aggregator.service;

import com.example.aggregator.client.ProductClient;
import com.example.aggregator.client.UserClient;
import com.example.aggregator.dto.UserProductResponseDTO;
import com.example.aggregator.dto.UserDTO;
import com.example.aggregator.dto.ProductMessageDTO;
import org.springframework.stereotype.Service;

@Service
public class AggregatorService {

    private final UserClient userClient;
    private final ProductClient productClient;

    public AggregatorService(UserClient userClient, ProductClient productClient) {
        this.userClient = userClient;
        this.productClient = productClient;
    }

    public UserProductResponseDTO getUserWithProductMessage(Long userId) {
        UserDTO user = userClient.getUserById(userId);
        ProductMessageDTO productMessage = productClient.getProductMessage();

        return new UserProductResponseDTO(user, productMessage);
    }
}
