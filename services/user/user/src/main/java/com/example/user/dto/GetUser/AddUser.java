package com.example.user.dto.GetUser;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUser {
    // kullanıcı ekleme yaparken id vermeyecek oto atanıtyor zaten
    private String name;
    private String lastName;
    private String email;
    private String password;
}
