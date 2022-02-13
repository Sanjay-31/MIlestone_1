package com.MIlestoneOne.springboot.Strategy;

import com.MIlestoneOne.springboot.model.ResponseClass;
import com.MIlestoneOne.springboot.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class Get_UserNotExist implements GetResponseInterface{
    @Override
    public ResponseEntity<Object> GetStatusResponse(User user) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("status","User Not Exist with");
        return  new  ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
    }
}
