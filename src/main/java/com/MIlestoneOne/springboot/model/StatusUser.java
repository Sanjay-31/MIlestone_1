package com.MIlestoneOne.springboot.model;

import com.MIlestoneOne.springboot.repository.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class StatusUser {

//    public static ResponseEntity<Object> StatusResponse(String message, HttpStatus status, Object responseObj) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("message", message);
//        map.put("status", status.value());
//        map.put("data", responseObj);
////        StatusUser ss=new StatusUser();
////        ss.firstNameOfUser=first;
////        ss.lastNameOfUser=last;
////        ss.Status=status;
////        return ss;
//
//        return new ResponseEntity<Object>(map,status);
//    }

//
    public Map<String,Object> StatusResponse(String message, User newUU)
    {
        Map<String,Object>map= new HashMap<String,Object>();
        map.put("status",message);
        map.put("Data",newUU);
        return map;
    }
}
