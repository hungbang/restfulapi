package com.controller;

import com.entity.UserEntity;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "protected/v1.0/api/users/delete/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<UserEntity> deleteById(@PathVariable final Integer userId ){
        UserEntity userEntity = userRepository.findOne(userId);

        if(userEntity == null) {
            return ResponseEntity.notFound().build();
        }

        userRepository.delete(userEntity);
        return ResponseEntity.ok().build();
    }
}
