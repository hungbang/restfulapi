package com.dao;

public interface UserDetailsDao {
    void updateFailAttempts(String username);
    void resetFailAttempts(String username);
}
