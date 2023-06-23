package com.Sprinhboot.ExamPortal;

import com.Sprinhboot.ExamPortal.entity.Role;
import com.Sprinhboot.ExamPortal.entity.User;
import com.Sprinhboot.ExamPortal.entity.UserRole;
import com.Sprinhboot.ExamPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamPortalApplication{
    @Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		User user = new User();
//		user.setEmail("allu.arjun@mail.com");
//		user.setPassword(this.bCryptPasswordEncoder.encode("1234"));
//		user.setUsername("AlluArjun");
//		user.setFirstName("Allu");
//		user.setLastName("Arjun");
//		user.setPhone("4447778889");
//		user.setProfile("allu.png");
//
//		Role role = new Role();
//		role.setRoleId(44L);
//		role.setRoleName("ADMIN");
//		UserRole userRole = new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//
//		Set<UserRole> userRoles = new HashSet<>();
//		userRoles.add(userRole);
//		User user1=userService.createUser(user,userRoles);
//		System.out.println(user1.getUsername());
//
//	}
}
