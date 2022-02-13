package com.MIlestoneOne.springboot.Strategy;

import com.MIlestoneOne.springboot.Service.ServiceLayer;
import com.MIlestoneOne.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class UserStrategy {


    private GetResponseInterface userInterface;
    public ResponseEntity<?> get(GetResponseInterface getResponseInterface, User u)
    {
//        ResponseClass r=new ResponseClass(serviceLayer.getById());
        return getResponseInterface.GetStatusResponse(u);
    }
}
