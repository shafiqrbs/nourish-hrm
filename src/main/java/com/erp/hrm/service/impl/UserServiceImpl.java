package com.erp.hrm.service.impl;

import com.erp.hrm.domain.CustomUserDetails;
import com.erp.hrm.domain.User;
import com.erp.hrm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
    	Optional<User> optionalUsers = userRepository.findUserByEmailOrUserName(email);
    	
    	optionalUsers
    		.orElseThrow(()-> new UsernameNotFoundException("User Name Not Found Exception"));
    	return optionalUsers.map(CustomUserDetails::new).get();
//        try {
//            Optional<User> optionalUsers = userRepository.findUserByEmailOrUserName(email);
//            return optionalUsers.map(CustomUserDetails::new).get();
//        }
//        catch (Exception e){
//            return null;
//        }
    }

}
