package com.bookin.bookin.service;

import com.bookin.bookin.requestmodels.JwtRegister;
import com.bookin.bookin.requestmodels.JwtRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public ResponseEntity<?> registerUser(JwtRegister jwtRegister) throws Exception;
    public ResponseEntity<?> loginUser(JwtRequest jwtRequest)throws Exception;
}
