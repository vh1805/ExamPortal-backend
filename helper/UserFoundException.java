package com.Sprinhboot.ExamPortal.helper;


public class UserFoundException extends Exception{
    public UserFoundException(){
        super("User with this username is already exist !!");
    }
    public UserFoundException(String message){
        super(message);
    }
}
