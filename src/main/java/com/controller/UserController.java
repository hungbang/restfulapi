package com.controller;

import com.entity.UsersEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {



    @PostMapping("/rest/protected/v1.0/api/register")
    public ResponseEntity<?> addUser(@RequestBody UsersEntity user) {

    }
}
