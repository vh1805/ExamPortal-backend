package com.Sprinhboot.ExamPortal.service.Impl;

import com.Sprinhboot.ExamPortal.entity.User;
import com.Sprinhboot.ExamPortal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user==null){
            System.out.println("User Not Found !!!");
            throw new UsernameNotFoundException("User Not Found");
        }
        return user;
    }
}
