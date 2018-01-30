package com.service;

import com.entity.UsersEntity;

public interface UserService {
    public void saveUser(UsersEntity user);
    public int checkUser(UsersEntity user);
}
