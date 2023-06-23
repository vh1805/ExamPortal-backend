package com.Sprinhboot.ExamPortal.controller;

import com.Sprinhboot.ExamPortal.config.JwtUtils;
import com.Sprinhboot.ExamPortal.entity.User;
import com.Sprinhboot.ExamPortal.entity.jwtRequest;
import com.Sprinhboot.ExamPortal.entity.jwtResponse;
import com.Sprinhboot.ExamPortal.helper.UserFoundException;
import com.Sprinhboot.ExamPortal.helper.UserNotFoundException;
import com.Sprinhboot.ExamPortal.service.Impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private JwtUtils jwtUtils;

    //generateTokenAPI
    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody jwtRequest jwtRequest) throws Exception {
        try{
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        }
        catch (UserNotFoundException e){
            e.printStackTrace();
            throw new Exception("User Not Found!!");
        }

        UserDetails userDetails = this.userDetailService.loadUserByUsername(jwtRequest.getUsername());

        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new jwtResponse(token));

    }

    private void authenticate(String username , String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }
        catch (DisabledException e){
            throw new Exception("USER DISABLED " + e.getMessage());
        }
        catch (BadCredentialsException e){
            throw new Exception("INVALID USER " + e.getMessage());
        }
    }
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
        return ((User) this.userDetailService.loadUserByUsername(principal.getName()));

    }
}
