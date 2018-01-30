package com.service;

import com.entity.UsersEntity;

public interface UserService {
    public void saveUser(UsersEntity user);
    public int checkUser(UsersEntity user);
    void confirmRegistration(String token);
    boolean isUserExist(String userName);
    UsersEntity getUserByEmail(String userName);
}
