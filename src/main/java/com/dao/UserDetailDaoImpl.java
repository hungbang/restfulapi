package com.dao;

import com.entity.UsersEntity;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailDaoImpl implements UserDetailsDao {

    @Autowired
    UserService userService;

    private static final int MAX_ATTEMPTS = 3;

    @Override
    public void updateFailAttempts(String username) {
        UsersEntity user = userService.getUserByEmail(username);

        if (user != null){
            if(user.getFailedLoginAttempts() +1 >= MAX_ATTEMPTS){
                throw new LockedException("User Account is locked!");
            }else {
                user.setFailedLoginAttempts(user.getFailedLoginAttempts()+1);
                userService.saveUser(user);
            }
        }
    }

    @Override
    public void resetFailAttempts(String username) {
        UsersEntity user = userService.getUserByEmail(username);

        if(user != null){
            user.setFailedLoginAttempts(0);
            userService.saveUser(user);
        }
    }
}
