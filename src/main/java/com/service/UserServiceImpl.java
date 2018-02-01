package com.service;

import com.entity.UsersEntity;
import com.exception.TokenInvalidExeption;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    JwtTokenService jwtTokenService;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void saveUser(UsersEntity user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(false);
        user.setCredentialsNonExpired(true);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        user.setCreated(dateFormat.format(date));
        user.setLastUpdatedAt(dateFormat.format(date));

        userRepository.save(user);
        emailService.sendMailConfirmation(user);
    }

    @Override
    public int checkUser(UsersEntity user) {
        UsersEntity userEntity = userRepository.findByEmail(user.getEmail());
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

    public void confirmRegistration(String token) throws TokenInvalidExeption {
        String userId = jwtTokenService.verifyToken(token);
        UsersEntity user = getUserById(Integer.parseInt(userId));
        if(user == null) {
            throw new TokenInvalidExeption("Token Invalid");
        }
        user.setAccessToken(token);
        user.setEnabled(true);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        user.setLastUpdatedAt(dateFormat.format(date));
        saveUser(user);
    }

    @Override
    public UsersEntity getUserById(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public boolean isUserExist(String userName) {
        UsersEntity usersEntity = userRepository.findByEmail(userName);
        if (usersEntity != null)
            return true;
        return false;
    }


    @Override
    public UsersEntity getUserByEmail(String userName) {
        return userRepository.findByEmail(userName);
    }
}
