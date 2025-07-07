package com.example.user.controller;

import com.example.user.dto.GetUser.AddUser;
import com.example.user.dto.GetUser.GetUser;
import com.example.user.model.UserModel;
import com.example.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public GetUser createUser(@RequestBody AddUser user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public GetUser getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<GetUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public GetUser deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

}
