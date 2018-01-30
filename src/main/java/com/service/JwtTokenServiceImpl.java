package com.service;

import com.entity.UsersEntity;
import com.exception.TokenInvalidExeption;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtTokenServiceImpl implements JwtTokenService{

    private static final Logger LOGGER= LoggerFactory.getLogger(JwtTokenServiceImpl.class);
    private static final String secretkey="ThisIsRestfulApi";
    private static final int expireDate=7200;
    @Override
    public String getToken(UsersEntity usersEntity) {
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.SECOND,expireDate);
        String token=Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject("Batch126127")
                .setExpiration(calendar.getTime())
                .claim("user-id",usersEntity.getId())
                .signWith(SignatureAlgorithm.HS512,secretkey)
                .compact();

        return token;
    }

    @Override
    public String verifyToken(String token) throws TokenInvalidExeption {
        Claims claims=Jwts.parser().setSigningKey(secretkey)
                .parseClaimsJws(token).getBody();
        Date expiration=claims.getExpiration();
        LOGGER.error("======confirm expiration :" + expiration);
        if(expiration.before(Calendar.getInstance().getTime()))
            throw new TokenInvalidExeption("Token is expired");
        String userId=claims.get("user-id").toString();
        LOGGER.info("userId is:" + userId);
        return userId;
    }
}
