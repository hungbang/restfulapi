package com.service;

import com.entity.UserEntity;

public interface UserService {
    public void saveUser(UserEntity user);
    public int checkUser(UserEntity user);
}
