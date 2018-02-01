package com.controller;

import com.entity.UsersEntity;
import com.exception.TokenInvalidExeption;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/public/v1.0/api/register")
    public ResponseEntity<?> addUser(@RequestBody UsersEntity user) {
        if(user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/protected/v1.0/api/confirm")
    public ResponseEntity<?> emailConfirm(@RequestParam String token) throws TokenInvalidExeption {
        userService.confirmRegistration(token);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
