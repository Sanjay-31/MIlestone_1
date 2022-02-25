package com.MIlestoneOne.springboot.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class StatusUser {

     public ResponseEntity<Object>  GetStatusResponse(String message, ResponseClass newUser)
    {
        Map<String,Object>map= new HashMap<String,Object>();
        map.put("status",message);
        map.put("Data",newUser);
        return  new  ResponseEntity<Object>(map,HttpStatus.FOUND);
    }

    public ResponseEntity<Object> PostStatusResponse(String message, User newUser) {
        Map<String,Object>map= new HashMap<String,Object>();
        map.put("status",message);
        map.put("Data",newUser);
        return  new  ResponseEntity<Object>(map,HttpStatus.CREATED);
    }
}
