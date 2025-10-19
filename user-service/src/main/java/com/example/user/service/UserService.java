package com.example.user.service;

import com.example.user.entity.User;
import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
}
