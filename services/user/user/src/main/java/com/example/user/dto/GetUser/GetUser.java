package com.example.user.dto.GetUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUser {
    private long id;
    private String name;
    private String lastName;
    private String email;
    // private String password; şifre göstermek istemiyorum
}
