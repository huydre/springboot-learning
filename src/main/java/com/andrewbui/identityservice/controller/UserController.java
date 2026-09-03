package com.andrewbui.identityservice.controller;

import com.andrewbui.identityservice.dto.request.UserCreationRequest;
import com.andrewbui.identityservice.dto.request.UserUpdateRequest;
import com.andrewbui.identityservice.entity.User;
import com.andrewbui.identityservice.repository.UserRepository;
import com.andrewbui.identityservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody @Valid UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") UUID userId) {

        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable("userId") UUID userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable("userId") UUID userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }
}
