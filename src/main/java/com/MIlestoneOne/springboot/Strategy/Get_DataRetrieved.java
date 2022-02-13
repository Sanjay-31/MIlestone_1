package com.MIlestoneOne.springboot.Strategy;

import com.MIlestoneOne.springboot.Service.ServiceLayer;
import com.MIlestoneOne.springboot.model.ResponseClass;

import com.MIlestoneOne.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class Get_DataRetrieved implements GetResponseInterface {

    //not able to autowired service layer because it's showing null object;
    @Override
    public ResponseEntity<Object> GetStatusResponse(User user) {
        ResponseClass newUser =new ResponseClass(user);
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("status","Data Successfully retrieved ");
        map.put("Data",newUser);
        return  new  ResponseEntity<Object>(map, HttpStatus.FOUND);
    }



}
