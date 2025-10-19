package com.example.user.controller;

import com.example.user.client.ProductClient;
import com.example.user.entity.User;
import com.example.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;
    private final ProductClient productClient;

    public UserController(UserService service, ProductClient productClient) {
        this.service = service;
        this.productClient = productClient;
    }

    @GetMapping("/product-message")
    public String callProductService() {
        // Call product service via Feign
        String response = productClient.getProductHello();
        return "User Service received: " + response;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }
}
