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

    public List<User>findAllUsers()
    {
        return userRepository.findAll();
    }

    public String getById(long id)
    {
        User u= userRepository.getById(id);
        return u.getFirstName() + "\n" +u.getLastName()+"\n"+u.getMobileNumber()+"\n"+u.getEmailID();
    }

    public boolean checkForTheUser(long id)
    {

        return userRepository.existsById(id);
//        List<User> users=userRepository.findAll();
//        for(User u:users)
//        {
//            if(u.getId()==id)
//                return  true;
//        }
//        return  false;
    }

    public boolean checkforExistingUser(User newUser) {
        List<User>list = userRepository.findAll();
            for(User user:list)
            {
                if(user.getUserName().equals(newUser.getUserName())
                        ||user.getEmailID().equals(newUser.getEmailID())
                        ||user.getMobileNumber()== newUser.getMobileNumber())
                  return true;
            }
            return false;
    }

    public void saveUser(User newUser) {
        userRepository.save(newUser);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public void UpdateUser(long id,User userdetails) {
        User updateuser = userRepository.getById(id);

        updateuser.setUserName(userdetails.getUserName());
        updateuser.setFirstName(userdetails.getFirstName());
        updateuser.setLastName(userdetails.getLastName());
        updateuser.setMobileNumber(userdetails.getMobileNumber());  // how to typecast from int to long
        updateuser.setEmailID(userdetails.getEmailID());
        updateuser.setAddress1(userdetails.getAddress1());
        updateuser.setAddress2(userdetails.getAddress2());
        userRepository.save(updateuser);
    }
}