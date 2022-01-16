package com.MIlestoneOne.springboot.repository;

import com.MIlestoneOne.springboot.exception.ResourcNotFoundException;
import com.MIlestoneOne.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceLayer {

    @Autowired
    private UserRepository userRepository;

    public User getBYIDbro(long id)
    {

        return userRepository.findById(id).orElseThrow(()-> new ResourcNotFoundException("User Not Exist"));
    }

}