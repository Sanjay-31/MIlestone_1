package com.MIlestoneOne.springboot.Strategy;

import com.MIlestoneOne.springboot.model.ResponseClass;
import com.MIlestoneOne.springboot.model.User;
import org.springframework.http.ResponseEntity;

public interface GetResponseInterface {
     ResponseEntity<Object> GetStatusResponse(User u);
}
