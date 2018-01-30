package com.DAO;

import com.entity.UsersEntity;

public interface UserDetailsDao {
    void updateFailAttempts(String username);
    void resetFailAttempts(String username);
}
