package com.service.impl;

import com.entity.UsersEntity;
import com.service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {

    public JavaMailSenderImpl getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("ReturnZeroZ1@gmail.com");
        mailSender.setPassword("Blackcat1");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setText(text);
        message.setSubject(subject);
        getJavaMailSender().send(message);
    }

    @Override
    public void sendMailConfirmation(UsersEntity user) {
        String token = "1234567asd";
        String link = "http://localhosT:8080/confirm?token=" + token;
        sendSimpleMessage(user.getEmail(),"Register Confirmation", link);
    }
}
