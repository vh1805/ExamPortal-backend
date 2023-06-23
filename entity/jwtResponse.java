package com.Sprinhboot.ExamPortal.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class jwtResponse {
    private String token;

    public jwtResponse(){
    }
    public jwtResponse(String token) {
        this.token = token;
    }
}
