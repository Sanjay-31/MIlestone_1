package com.MIlestoneOne.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

//class to handle runtime exception
public class ResourcNotFoundException extends RuntimeException{

    //constructor
    public ResourcNotFoundException(String message)
    {
         super(message);
    }
}
