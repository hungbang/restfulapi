package com.repository;

import com.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UsersEntity, Integer> {
    UsersEntity findByUsername(String name);
}
