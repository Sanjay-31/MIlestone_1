package com.MIlestoneOne.springboot.Service;

import com.MIlestoneOne.springboot.model.User;
import com.MIlestoneOne.springboot.repository.ServiceLayer;
import com.MIlestoneOne.springboot.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@SpringBootTest
public class TestServiceClass {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ServiceLayer serviceLayer;

    private User user1,user2;
    private List<User>listOfUser;

    @BeforeEach
    void addObject()
    {
        user1=new  User(5, "Ram345", "Ram",
                "NewEvans", "newChirs@gmail.com", 8999, "Upstate", "NewYork");
        user2=new  User(6, "Manoj345", "Manoj",
                "NewEvans", "newChirs@gmail.com", 8999, "Upstate", "NewYork");
        listOfUser=new ArrayList<User>();
        listOfUser.add(user1);
        listOfUser.add(user2);
    }
    @AfterEach
    void DeleteObjects()
    {
        user1=null;
        user2=null;
        listOfUser.clear();
    }
    @Test
    void getAllUserTest()
    {
        User user3=new  User(7, "Adam123", "Adam",
                "NewEvans", "newChirs@gmail.com", 8999, "Upstate", "NewYork");
        listOfUser.add(user3);
        when(userRepository.findAll()).thenReturn(listOfUser);
        int expected=serviceLayer.findAllUsers().size();
        assertEquals(expected,3);
    }
    @Test
    void getByIdTest()
    {
    when(userRepository.findById(5L)).thenReturn(Optional.ofNullable(user1));
    User expectedUser=serviceLayer.getById(5L);
    String expectedUserName=expectedUser.getUserName();
        assertEquals(expectedUserName,"Ram345");
        System.out.println(expectedUserName);
    }
    @Test
    void CheckForTheUserByIdTest()
    {
        when(userRepository.existsById(5L)).thenReturn(true);
        assertTrue(serviceLayer.checkForTheUser(5L));
    }

    @Test
    void UpdateTest()
    {
       User newUser= new User(5, "Mukesh345", "Ram",
               "NewEvans", "newChirs@gmail.com", 8999, "Upstate", "NewYork");
       when(userRepository.getById(5L)).thenReturn(user1);
//       when(userRepository.save(user1)).thenReturn(user1);
       serviceLayer.UpdateUser(5L,newUser);
       assert(user1.getUserName()).equals("Mukesh345");
    }
    @Test
    void CheckForExistingUserTest()
    {
        when(userRepository.findAll()).thenReturn(listOfUser);
        assertTrue(serviceLayer.checkforExistingUser(user1),"Checking whether a user exist of not");
    }
}
