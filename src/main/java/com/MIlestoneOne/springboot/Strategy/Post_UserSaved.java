package com.MIlestoneOne.springboot.Strategy;

import com.MIlestoneOne.springboot.model.ResponseClass;
import com.MIlestoneOne.springboot.model.User;
import com.MIlestoneOne.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class Post_UserSaved implements GetResponseInterface {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<Object> GetStatusResponse(User user) {
        return null;
    }
}
