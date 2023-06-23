package com.Sprinhboot.ExamPortal.service;

import com.Sprinhboot.ExamPortal.entity.User;
import com.Sprinhboot.ExamPortal.entity.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    User getUserDetailByUsername(String username) throws Exception;

    List<User> getAllUserDetails();

    String deleteUserByUsername(Long userId);
}
