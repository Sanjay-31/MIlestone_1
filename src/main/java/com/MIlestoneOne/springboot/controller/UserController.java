package com.MIlestoneOne.springboot.controller;

import com.MIlestoneOne.springboot.model.StatusUser;
import com.MIlestoneOne.springboot.model.User;
import com.MIlestoneOne.springboot.repository.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController   //by this annotation we are declaring here that this class is a controller ,by using our class is capable of handling http request
@RequestMapping("/user")

// all the rest api operation we do , we define in this class.
public class UserController {

    @Autowired
    private ServiceLayer serviceLayer;

    StatusUser statusUser=new StatusUser();

    //get method or read method for reading all the data from the database
    @GetMapping
    public List<User> getALlUser()
    {
        return serviceLayer.findAllUsers();
    }

    //GET method for a specific ID or Read Method
    @GetMapping("{id}")
    public Map<String,Object> getUserById(@PathVariable long id)
    {

              if(serviceLayer.checkForTheUser(id))
              {
                  User u= serviceLayer.getById(id);

                  return statusUser.StatusResponse("Retrieving Data Successfull",u);
              }
              else
              {
                  return statusUser.StatusResponse("User Not Exists",null);
              }

//        Map<String,Object>map= new HashMap<String,Object>();
//        map.put("status","Successss");
//        map.put("Data",u);
//        map.put("Http Status",HttpStatus.OK.value());
//        return map;
//           StatusUser statusUser=new StatusUser();
//        if(serviceLayer.checkForTheUser(id))
//        {
//            User u= serviceLayer.getById(id);
//        return statusUser.StatusResponse("Retrieval succesfull",HttpStatus.OK,u);
//
////          return statusUser.StatusResponse("Successssss",u);
////          return statusUser.StatusResponse("User is successfully retieved",HttpStatus.OK,u);
//        }
//        else
//        {
//            return statusUser.StatusResponse("User Not Found",HttpStatus.MULTI_STATUS,null);
////           return statusUser.StatusResponse("noooooot exist",null);
//        }
    }
//status error

    //POST method or Create Method
    @PostMapping
    public String createUser (@RequestBody User newUser)//@RequestBody will automatically convert JSON object to Java object
    {

        serviceLayer.saveUser(newUser);
        return "Saveddd";
////        StatusUser statusUser=new StatusUser();
//
//        if(serviceLayer.checkforExistingUser(newUser))
//        {
//            return statusUser.StatusResponse("User Already exist", HttpStatus.OK, newUser);
//        }
//        else
//        {
//            serviceLayer.saveUser(newUser);
//            return StatusUser.StatusResponse("User saved", HttpStatus.MULTI_STATUS, newUser);
//        }
    }



    //PUT method (update a specific ID) or Update Method
    @PutMapping("{id}")
    public String updateUser(@PathVariable long id,@RequestBody User UpdatedUser)
    {
        if(serviceLayer.checkForTheUser(id))
        {
            serviceLayer.UpdateUser(id,UpdatedUser);
            return "User Updated";
        }
        else
        {
            return "User not exist";
        }
    }

    //Delete Method for a specific id
    @DeleteMapping("{id}")
    public String deleteEmployee(@PathVariable long id)
    {
        if(serviceLayer.checkForTheUser(id))
        {
            serviceLayer.deleteUser(id);
            return "User Deleted";
        }
        else
        {
            return "User not exist";
        }
    }
}
