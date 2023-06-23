package com.Sprinhboot.ExamPortal.service.Impl;

import com.Sprinhboot.ExamPortal.entity.User;
import com.Sprinhboot.ExamPortal.entity.UserRole;
import com.Sprinhboot.ExamPortal.helper.UserFoundException;
import com.Sprinhboot.ExamPortal.repository.RoleRepository;
import com.Sprinhboot.ExamPortal.repository.UserRepository;
import com.Sprinhboot.ExamPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = userRepository.findByUsername(user.getUsername());
        if(local!=null){
            System.out.println("User is already there !!!");
            throw new UserFoundException("User Already Exist");
        }
        else
        {
            for (UserRole ur : userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = userRepository.save(user);
        }
        return local;
    }

    @Override
    public User getUserDetailByUsername(String username) throws Exception {
        User local = userRepository.findByUsername(username);
        if(local==null){
            System.out.println("No User Exist !!!!");
            throw new Exception("User Doesn't Exist !!!!");
        }
        else {
            return local;
        }
    }

    @Override
    public List<User> getAllUserDetails() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public String deleteUserByUsername(Long userId) {
        userRepository.deleteById(userId);
        return "User Deleted Successfully";

    }

    }

