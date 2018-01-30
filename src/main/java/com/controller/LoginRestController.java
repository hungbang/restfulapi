package com.controller;

import com.entity.UsersEntity;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginRestController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody UsersEntity userEntity){
        int check = userService.checkUser(userEntity);

        if(check == 0){
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        if(check == -1 || check == 1 || check == 2){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Username or password is invalid!");
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("This account has been locked since you entered the wrong password 3 times!");
    }

}
