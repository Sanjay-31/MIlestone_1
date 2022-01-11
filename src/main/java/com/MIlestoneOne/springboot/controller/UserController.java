package com.MIlestoneOne.springboot.controller;

import com.MIlestoneOne.springboot.exception.ResourcNotFoundException;
import com.MIlestoneOne.springboot.model.User;
import com.MIlestoneOne.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   // by using this our class is capable of handling http request
@RequestMapping("/user")

// all the rest api operation we do , we define in this class.
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //get method or read method for reading all the data from the database
    @GetMapping
    public List<User> getALlUser()
    {
        return userRepository.findAll();
    }

    //POST method or Create Method
    @PostMapping
    public User createUser (@RequestBody User user)//@RequestBody will automatically convert JSON object to Java object
    {
        return userRepository.save(user);
    }

    //GET method for a specific ID or Read Method
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id)
    {
        User user= userRepository.findById(id)
                .orElseThrow(()-> new ResourcNotFoundException("User not founded with id:"+id));
        return ResponseEntity.ok(user);
    }

    //PUT method (update a specific ID) or Update Method
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User userdetails)
    {
        User updateuser=userRepository.findById(id)
                .orElseThrow(()->new ResourcNotFoundException("User not founded with the id: "+id));

        updateuser.setUserName(userdetails.getUserName());
        updateuser.setFirstName(userdetails.getFirstName());
        updateuser.setLastName(userdetails.getLastName());
        updateuser.setMobileNumber(userdetails.getMobileNumber());  // how to typecast from int to long
        updateuser.setEmailID(userdetails.getEmailID());
        updateuser.setAddress1(userdetails.getAddress1());
        updateuser.setAddress2(userdetails.getAddress2());

        userRepository.save(updateuser);
        return ResponseEntity.ok(updateuser);
    }

    //Delete Method for a specific id
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id)
    {
        User deleteduser=userRepository.findById(id)
                .orElseThrow(()->new ResourcNotFoundException("User does not exit"));
        userRepository.delete(deleteduser);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
