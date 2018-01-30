package com.controller;

import com.entity.UsersEntity;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/rest/protected/v1.0/api/register")
    public ResponseEntity<?> addUser(@RequestBody UsersEntity user) {
        if(user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/confirm")
    public ResponseEntity<?> emailConfirm(@RequestParam String token)  {
        userService.confirmRegistration(token);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
