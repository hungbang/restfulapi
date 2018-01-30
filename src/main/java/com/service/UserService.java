package com.service;

import com.entity.UsersEntity;

public interface UserService {
    void saveUser(UsersEntity user);
    void confirmRegistration(String token);
}
