package com.bookin.bookin.service;

import com.bookin.bookin.requestmodels.JwtRegister;
import com.bookin.bookin.requestmodels.JwtRequest;
import com.bookin.bookin.requestmodels.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public JwtResponse registerUser(JwtRegister jwtRegister) throws Exception;
    public JwtResponse loginUser(JwtRequest jwtRequest)throws Exception;
}
