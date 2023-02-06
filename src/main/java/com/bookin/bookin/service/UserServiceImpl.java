package com.bookin.bookin.service;


import com.bookin.bookin.dao.UserDao;
import com.bookin.bookin.entity.Users;
import com.bookin.bookin.requestmodels.JwtRegister;
import com.bookin.bookin.requestmodels.JwtRequest;
import com.bookin.bookin.requestmodels.JwtResponse;
import com.bookin.bookin.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class  UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UserDao userDao;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    public JwtResponse registerUser(JwtRegister jwtRegister) throws Exception {
        userDao.addUser(new Users(jwtRegister));
        return loginUser(new JwtRequest(jwtRegister));
    }


    public JwtResponse loginUser(JwtRequest jwtRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword())
            );
        } catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        } catch(Exception e){
            throw new Exception("exception in login",e);
        }

        final Optional<Users> user =userDao.findByUsername(jwtRequest.getUserName());
        String Jwt = jwtUtil.generateToken(userDetailsService.loadUserByUsername(jwtRequest.getUserName()));


        return new JwtResponse(Jwt);
    }

}
