package com.controller;

import com.entity.RegisterParam;
import com.entity.UserEntity;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public RedirectView handleRegister(@ModelAttribute("user") RegisterParam registerParam){
        String username = registerParam.getUserName();
        String password = registerParam.getPassWord();
        UserEntity user = new UserEntity(username, encoder.encode(password));

        userService.saveUser(user);
        return new RedirectView("/rest/login");
    }

    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }
}
