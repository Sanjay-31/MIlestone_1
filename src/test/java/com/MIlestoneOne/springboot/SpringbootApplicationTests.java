package com.MIlestoneOne.springboot;

import com.MIlestoneOne.springboot.model.User;
import com.MIlestoneOne.springboot.repository.ServiceLayer;
import com.MIlestoneOne.springboot.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
class SpringbootApplicationTests {

	@InjectMocks
	private ServiceLayer serviceLayer;

	@MockBean
	private UserRepository repository;

	@Test
	void contextLoads() {
	}
	@Test
	void TestService()
	{
		when(repository.findById(50L)).thenReturn(java.util.Optional.of(new User(50, "NewCaptain America", "NewChirs",
				"NewEvans", "newChirs@gmail.com", 8999, "Upstate", "NewYork")));

//		User expected=new User(50,"NewCaptain America","NewChirs",
//				"NewEvans","newChirs@gmail.com",8999,"Upstate","NewYork");
//		User current=serviceLayer.getById(50);
//       assert(current.getAddress1()).equals("Upstate");
//		assert(current.getUserName()).equals("NewCaptain America");
//		assert(current.getFirstName()).equals("NewChirs");
//		assert(current.getLastName()).equals("NewEvans");
//		assertEquals(current.getMobileNumber(),8999);
	}
}
