package com.service;

import com.entity.UsersEntity;
import com.exception.TokenInvalidExeption;

public interface JwtTokenService {
    String getToken(UsersEntity usersEntity);
    String verifyToken(String token) throws TokenInvalidExeption;
}
