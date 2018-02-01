package com.service;

import com.entity.UsersEntity;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public interface EmailService {
    void sendMailConfirmation(UsersEntity users);
}
