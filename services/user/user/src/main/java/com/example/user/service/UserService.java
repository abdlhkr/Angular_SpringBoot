package com.example.user.service;

import com.example.user.dto.GetUser.AddUser;
import com.example.user.dto.GetUser.GetUser;
import com.example.user.model.UserModel;

import java.util.List;

public interface UserService {
    // normal user alıcak ama kaydolunca şifre gelmeyecek
    GetUser saveUser(AddUser user);
    GetUser getUserById(Long id);
    List<GetUser> getAllUsers();
    GetUser deleteUser(Long id);
}
