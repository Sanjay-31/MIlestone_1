package com.MIlestoneOne.springboot.Service;

import com.MIlestoneOne.springboot.model.User;
import com.MIlestoneOne.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public User getById(long id)
    {
        return userRepository.findById(id).get();
    }

    public boolean checkForTheUser(long id)
    {
        return userRepository.existsById(id);
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
        userRepository.save(updateuser);//it has no use when we do update test because it is nullable and also it didn't returning anything.
        System.out.println("updating user completed");
    }
}