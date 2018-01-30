package com.service;

import com.entity.UsersEntity;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public void saveUser(UsersEntity user) {
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(false);
        user.setCredentialsNonExpired(true);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        user.setCreated(dateFormat.format(cal));
        user.setLastUpdatedAt(dateFormat.format(cal));

        userRepository.save(user);
        emailService.sendMailConfirmation(user);
    }
}
