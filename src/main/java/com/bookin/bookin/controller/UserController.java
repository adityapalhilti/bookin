package com.bookin.bookin.controller;


import com.bookin.bookin.entity.Users;
import com.bookin.bookin.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.bookin.bookin.requestmodels.JwtRegister;
import com.bookin.bookin.requestmodels.JwtRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/signups")
    public ResponseEntity<?> registerUser(@RequestBody JwtRegister jwtRegister) throws Exception {
        return ResponseEntity.ok(userServiceImpl.registerUser(jwtRegister));

    }

    @PostMapping("/logins")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        return ResponseEntity.ok(userServiceImpl.loginUser(jwtRequest));
    }
}