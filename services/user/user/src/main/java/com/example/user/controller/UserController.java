package com.example.user.controller;

import com.example.user.dto.GetUser.AddUser;
import com.example.user.dto.GetUser.GetUser;

import com.example.user.dto.GetUser.LoginUser;
import com.example.user.dto.GetUser.Sil;
import com.example.user.model.UserModel;
import com.example.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("/create")
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

    @PostMapping("/find")
    public boolean login(@RequestBody LoginUser user) {
        return userService.login(user);
    }

    @DeleteMapping("/delete")
    public void deleteAll(@RequestBody Sil idList) {
        userService.deleteAll(idList);
    }
}
