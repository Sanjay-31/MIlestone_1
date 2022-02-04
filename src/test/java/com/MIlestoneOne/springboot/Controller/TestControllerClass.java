package com.MIlestoneOne.springboot.Controller;


import com.MIlestoneOne.springboot.controller.UserController;
import com.MIlestoneOne.springboot.model.GetResponse;
import com.MIlestoneOne.springboot.model.User;
import com.MIlestoneOne.springboot.repository.ServiceLayer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.apache.tomcat.util.json.JSONParser;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static sun.awt.util.PerformanceLogger.times;

//@AutoConfigureMockMvc
//@SpringBootTest
////@ExtendWith(MockitoExtension.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//@AutoConfigureMockMvc
//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestControllerClass {

    @Mock
    private ServiceLayer serviceLayer;
    @InjectMocks
    private UserController userController;

    @Autowired
    private MockMvc mockMvc;

    private User user1,user2;

    @BeforeEach
    void Setup()
    {
        mockMvc= MockMvcBuilders.standaloneSetup(userController).build();

        user1=new  User(5, "Ram345", "Ram",
                "NewEvans", "newChirs@gmail.com", 8999, "Upstate", "NewYork");
        user2=new  User(6, "Manoj345", "Manoj",
                "NewEvans", "newChirs@gmail.com", 8999, "Upstate", "NewYork");
    }

    @Test
    void getUserByIdTest()throws Exception{
        when(serviceLayer.checkForTheUser(5)).thenReturn(true);
        when(serviceLayer.getById(5)).thenReturn(user1);

        MvcResult mvcResult= mockMvc.perform(
                MockMvcRequestBuilders.get("/user/5").
                        contentType(MediaType.APPLICATION_JSON)//specifying the type of content;
                        .content(asJsonString(user1))//giving the content;
//        ).andExpect(status().isOk()).andReturn();
        ).andReturn();
        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        verify(serviceLayer).getById(5);
        System.out.println("get by id verified");
    }

    @Test
    void createUserTest() throws Exception {
        when(serviceLayer.checkforExistingUser(any())).thenReturn(false);
        mockMvc.perform(MockMvcRequestBuilders.post("/user").
                contentType(MediaType.APPLICATION_JSON).
                content(asJsonString(user1))).
                andExpect(status().isCreated());
        verify(serviceLayer,times(1)).saveUser(any());
    }


    @Test
    void deleteEmployeeTest() throws Exception
    {
        when(serviceLayer.checkForTheUser(6)).thenReturn(true);
//        when()
       MvcResult mvcResult= mockMvc.perform(
                MockMvcRequestBuilders.delete("/user/6")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user2))).andReturn();
        int status=mvcResult.getResponse().getStatus();
        assertEquals(200,status);
        verify(serviceLayer).deleteUser(6);
    }

    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }








//    @BeforeEach
//    void Setup()
//    {
//        mockMvc= MockMvcBuilders.standaloneSetup(userController).build();
//
//        user1=new  User(5, "Ram345", "Ram",
//                "NewEvans", "newChirs@gmail.com", 8999, "Upstate", "NewYork");
//        user2=new  User(6, "Manoj345", "Manoj",
//                "NewEvans", "newChirs@gmail.com", 8999, "Upstate", "NewYork");
//        listOfUser=new ArrayList<User>();
//        listOfUser.add(user1);
//        listOfUser.add(user2);
//    }
//   @AfterEach
//   void TearDown()
//   {
//       listOfUser.clear();
//   }
//
//   @Test
//   void TestcreateUser() throws JsonProcessingException {
//        System.out.println(user1.toString());
//         String inputJson=this.mapToJson(user1);
//       System.out.println(inputJson);
//   }
//
//    private String mapToJson(Object obj) throws JsonProcessingException {
//        ObjectMapper objectMapper=new ObjectMapper();
//        return objectMapper.writeValueAsString(obj);
//    }
//
//
//    @Test
////    @Disabled
//    void getALlUserTest() throws Exception {
//        User user3 = new User(7, "Ghanshyam345", "GhanShyam",
//                "NewEvans", "newChirs@gmail.com", 8999, "Upstate", "NewYork");
//        listOfUser.add(user3);
//        Mockito.when(serviceLayer.findAllUsers()).thenReturn(listOfUser);
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/user")
//        ).andExpect(status().isOk())
//                .andExpect(jsonPath("$", Matchers.hasSize(3))
//                );
////        int status;
////        MvcResult mvcResult = mockMvc.perform(
////                MockMvcRequestBuilders.get("/user")
////        )
////                .andExpect(status().isOk())
////                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)).andReturn();
////        status = mvcResult.getResponse().getStatus();
////        assertEquals(200, status);
////        String content = mvcResult.getResponse().getContentAsString();
////        System.out.println(content);
//    }
//
//    @Test
////    @Disabled
//    void getUserByIdTest() throws Exception
//    {
//
//        Mockito.when(serviceLayer.checkForTheUser(6)).thenReturn(true);
//        Mockito.when(serviceLayer.getById(6)).thenReturn(user2);
////       int id =user1.getId();
//        Mockito.when(serviceLayer.findAllUsers()).thenReturn(listOfUser);
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/user/6")
//               ).andExpect(status().isOk())
//                .andExpect(jsonPath("$.Data", Matchers.is("NewEvans"))
//                );
//    }
}
