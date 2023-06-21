package com.Sprinhboot.ExamPortal.controller;

import com.Sprinhboot.ExamPortal.entity.Role;
import com.Sprinhboot.ExamPortal.entity.User;
import com.Sprinhboot.ExamPortal.entity.UserRole;
import com.Sprinhboot.ExamPortal.helper.UserFoundException;
import com.Sprinhboot.ExamPortal.helper.UserNotFoundException;
import com.Sprinhboot.ExamPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        Role role = new Role();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        role.setRoleId(45L);
        role.setRoleName("NORMAL USER");
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        Set<UserRole> userRoleSet = new HashSet<>();
        userRoleSet.add(userRole);

        return userService.createUser(user,userRoleSet);
    }

    @GetMapping("/{username}")
    public User getUserDetailByUsername(@PathVariable("username") String username) throws Exception{
        return userService.getUserDetailByUsername(username);
    }

    @GetMapping("/")
    public List<User> getAllUserDetails(){
        return userService.getAllUserDetails();
    }

    @DeleteMapping("/{userId}")
    public String deleteUserByUserId(@PathVariable("userId") Long userId){
        return userService.deleteUserByUsername(userId);
    }

    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exeptionHandler(UserFoundException e) {
        return ResponseEntity.ok(e.getMessage());
    }
}

