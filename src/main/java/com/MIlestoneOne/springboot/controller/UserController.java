package com.MIlestoneOne.springboot.controller;
import com.MIlestoneOne.springboot.Strategy.GetResponseInterface;
import com.MIlestoneOne.springboot.Strategy.Get_DataRetrieved;
import com.MIlestoneOne.springboot.Strategy.Get_UserNotExist;
import com.MIlestoneOne.springboot.Strategy.UserStrategy;
import com.MIlestoneOne.springboot.model.ResponseClass;
import com.MIlestoneOne.springboot.model.StatusUser;
import com.MIlestoneOne.springboot.model.User;
import com.MIlestoneOne.springboot.Service.ServiceLayer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController   //by this annotation we are declaring here that this class is a controller ,by using our class is capable of handling http request
@RequestMapping("/user")
// all the rest api operation we do , we define in this class.
public class UserController {

    Logger logger= LogManager.getLogger(UserController.class);
    @Autowired
    private ServiceLayer serviceLayer;

    private ObjectMapper objectMapper;
    private UserStrategy userStrategy=new UserStrategy();

    StatusUser statusUser=new StatusUser();

    //get method or read method for reading all the data from the database
    @GetMapping
    public ResponseEntity<?> getALlUser()
    {
            List<User>list=serviceLayer.findAllUsers();
            if(list.size()>0)
            {
                logger.info("List of user : "+list.size());
                return new ResponseEntity<>(list,HttpStatus.FOUND);
            }
            else
            {
                logger.error("No User Present");
                return new ResponseEntity<>("Error Message : No User Present",HttpStatus.NOT_FOUND);
            }
    }
    //GET method for a specific ID or Read Method
    @GetMapping("{id}")
    public ResponseEntity<?> getUserById(@PathVariable long id) {

//        Map<Boolean, GetResponseInterface>mapInterface =new HashMap<>();
//        mapInterface.put(true,new Get_DataRetrieved());
//        mapInterface.put(false,new Get_UserNotExist());
//        Map<Boolean, User>map=new HashMap<>();
//        map.put(true,serviceLayer.getById(id));
//        map.put(false,null);
//          UserStrategy userStrategy=new UserStrategy();
//          boolean exist=serviceLayer.checkForTheUser(id);
//          return userStrategy.get(
//                  mapInterface.get(exist),map.get(exist)
//          );
        if(serviceLayer.checkForTheUser(id))
        {
            User u= serviceLayer.getById(id);
            ResponseClass r=new ResponseClass(u);
            logger.info(asJsonString(r));
            return statusUser.GetStatusResponse("Data Successfully retrieved",r);
        }
        else
        {
            logger.error("No User exists with id : "+id);
            return statusUser.GetStatusResponse("User Not Exists",null);
        }
    }
    //POST method or Create Method
    @PostMapping
    public ResponseEntity<Object> createUser (@RequestBody User newUser)//@RequestBody will automatically convert JSON object to Java object
    {
        if(serviceLayer.checkforExistingUser(newUser))
        {
            logger.error("User Already exist with id : "+newUser.getId());
            return statusUser.PostStatusResponse("A User Already exist with same credentials", newUser);
        }
        else
        {
            serviceLayer.saveUser(newUser);
            logger.info("User saved with id : "+newUser.getId());
            return statusUser.PostStatusResponse("User saved", newUser);
        }
    }

    //PUT method (update a specific ID) or Update Method
    @PutMapping("{id}")
    public String updateUser(@PathVariable long id,@RequestBody User UpdatedUser)
    {
        if(serviceLayer.checkForTheUser(id))
        {
//            logger.info("User ");
            serviceLayer.UpdateUser(id,UpdatedUser);
            return "User Updated";
        }
        else
        {
            logger.error("User Not exist with id : "+id);
            return "User not exist";
        }
    }

    //Delete Method for a specific id
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable long id)
    {
        if(serviceLayer.checkForTheUser(id))
        {
            serviceLayer.deleteUser(id);
            return  new ResponseEntity<>("User Deleted",HttpStatus.OK);
        }
        else
        {
            logger.error("User Not exist with id : "+id);
            return  new ResponseEntity<>("User Not Exist",HttpStatus.NOT_FOUND);
        }
    }
    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
