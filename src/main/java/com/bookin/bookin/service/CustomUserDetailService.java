package com.bookin.bookin.service;

import com.bookin.bookin.dao.UserDao;
import com.bookin.bookin.entity.Users;
import com.bookin.bookin.util.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {
    //@Override
    //public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

//        if(userName.equals("John")){
//            return new User("John","secret", new ArrayList<>());
//        }
//        else {
//            throw new UsernameNotFoundException("User does not Exist!");
//        }


        @Autowired
        UserDao userDao;

        @Override
        public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
            Optional<Users> user= userDao.findByUsername(userName);
            user.orElseThrow(()-> new UsernameNotFoundException("Not found : "+ userName));

            return user.map(CustomUserDetails::new).get();
        }
    }

