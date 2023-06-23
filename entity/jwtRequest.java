package com.Sprinhboot.ExamPortal.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class jwtRequest {

    private String username;
    private String password;

    public jwtRequest(){
    }

    public jwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
