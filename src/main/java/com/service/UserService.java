package com.service;

import com.entity.UsersEntity;
import com.exception.TokenInvalidExeption;

public interface UserService {
    public void saveUser(UsersEntity user);
    public int checkUser(UsersEntity user);
    void confirmRegistration(String token) throws TokenInvalidExeption;
    UsersEntity getUserById(int id);
    boolean isUserExist(String userName);
    UsersEntity getUserByEmail(String userName);
}
