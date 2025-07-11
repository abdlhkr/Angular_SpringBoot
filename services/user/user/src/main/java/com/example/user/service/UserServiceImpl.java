package com.example.user.service;

import com.example.user.dto.GetUser.AddUser;
import com.example.user.dto.GetUser.GetUser;
import com.example.user.dto.GetUser.LoginUser;
import com.example.user.dto.GetUser.Sil;
import com.example.user.model.UserModel;
import com.example.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private GetUser toGetUser(UserModel user) {
        return new GetUser(user.getId(),user.getName(),user.getLastName(),user.getEmail());
    }

    private UserModel toEntity(AddUser user) {
        return new UserModel(
                0L,                      // id otomatik atanacak
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword()
        );
    }

    @Override
    public GetUser saveUser(AddUser user) {
        return toGetUser(userRepository.save(toEntity(user)));
    }

    @Override
    public GetUser getUserById(Long id) {
        UserModel user = userRepository.findById(id).orElse(null);
        return toGetUser(user);
    }

    @Override
    public List<GetUser> getAllUsers() {
//        List<UserModel> users = userRepository.findAll();
//        List<GetUser> getUsers = new ArrayList<>();
//        for (UserModel user : users) {
//            getUsers.add(toGetUser(user));
//        }
//        return getUsers;
        return userRepository.findAll()
                .stream()
                .map(this::toGetUser)
                .collect(Collectors.toList());
    }

    @Override
    @DeleteMapping("/{id}")
    public GetUser deleteUser(@PathVariable Long id) {
        UserModel user = userRepository.findById(id).orElse(null);
        userRepository.delete(user);
        return toGetUser(user);
    }


    public void deleteAll(@RequestBody Sil idList){
        userRepository.deleteAllById(idList.getIdList());
    }

    public boolean login(LoginUser user) {
        UserModel customer = userRepository.findByEmail(user.getEmail());
        if (customer == null) {
            return  false;
        }else {
            return user.getPassword().equals(customer.getPassword());
        }
    }
}
