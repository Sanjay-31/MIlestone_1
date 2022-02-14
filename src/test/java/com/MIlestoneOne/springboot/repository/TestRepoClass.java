package com.MIlestoneOne.springboot.repository;

import com.MIlestoneOne.springboot.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TestRepoClass {

    @Autowired
    private UserRepository userRepository;
    private String userName;
     private User u;

    @AfterEach
    void deleteUser()
    {
        userRepository.deleteById(userRepository.getByUserName(userName).getId());

        System.out.println("Delete is called " +userName);
    }
    @BeforeEach
    void addUser()
    {
        u=new User(5, "Shyam123", "Shyam",
                "NewEvans", "newChirs@gmail.com", 8999, "Upstate", "NewYork");
        userRepository.save(u);
    }

    @Test
    void TestIsPersonAdded()
    {

        User actualUser =userRepository.getByUserName("Shyam123");
        boolean actual=userRepository.existsById(actualUser.getId());
         assertThat(actual).isTrue();
    }
//
//    @Test
//    void TestUpdateUser()
//    {
//      long Id=u.getId();
//      userName="SriShyam";
//      u.setUserName("SriShyam");
//      userRepository.save(u);
////              System.out.println(Id);
////        System.out.println("update function .."+u.getUserName());
//
////      System.out.println(userRepository.getByUserName(userName).getId());
////        User newUser=userRepository.getByUserName(userName);
////      assertThat(newUser.getId()).isEqualTo(Id);
//
//    }
}
