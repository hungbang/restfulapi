package com.config;

import com.DAO.UserDetailsDao;
import com.entity.UsersEntity;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component("authenticationProvider")
public class CheckLoginAuthenticationProvider extends DaoAuthenticationProvider {
    @Autowired
    UserDetailsDao userDetailsDao;

    @Autowired
    UserService userService;

    @Autowired
    @Override
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        super.setUserDetailsService(userDetailsService);
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        try {
            Authentication auth = super.authenticate(authentication);
            userDetailsDao.resetFailAttempts(authentication.getName());

            return auth;

        } catch (BadCredentialsException e) {
            userDetailsDao.updateFailAttempts(authentication.getName());
            throw e;

        } catch (LockedException e){
            String error = "this user is locked";
            UsersEntity userAttempts =
                    userService.findByUserName(authentication.getName());

            if(userAttempts!=null){
                error = "User account is locked! <br><br>Username : "
                        + authentication.getName() + "<br>Last Attempts : " + userAttempts.getLastUpdatedAt();
            }else{
                error = e.getMessage();
            }

            throw new LockedException(error);
        }

    }
}
