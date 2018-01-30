package com.service;

import com.entity.UserEntity;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public int checkUser(UserEntity user) {
        UserEntity userEntity = userRepository.findByUsername(user.getUsername());
        if(userEntity == null)
            return -1;
        if(user.getPassword().equals(userEntity.getPassword())){
            userEntity.setFailedLoginAttempts(0);
            userRepository.save(userEntity);
            return 0;
        }
        if(userEntity.getFailedLoginAttempts() == 2){
            userEntity.setAccountNonLocked(false);
            userRepository.save(userEntity);
            return 3;
        }
        userEntity.setFailedLoginAttempts(userEntity.getFailedLoginAttempts()+1);
        return userEntity.getFailedLoginAttempts();
    }
}
