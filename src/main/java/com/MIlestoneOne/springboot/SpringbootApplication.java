package com.MIlestoneOne.springboot;

import com.MIlestoneOne.springboot.model.User;
import com.MIlestoneOne.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
//		User user=new User();
//		user.setUserName("Honey");
//		user.setFirstName("Sanjay");
//		user.setLastName("Shakya");
//		user.setMobileNumber(7354);
//		user.setEmailID("sanjay@gmail.com");
//		user.setAddress1("Shubham Parisar");
//		user.setAddress2("Shastri Nagar");
//		userRepository.save(user);
//
//		User user1=new User();
//		user1.setUserName("IronMan");
//		user1.setFirstName("Tony");
//		user1.setLastName("Stark");
//		user1.setMobileNumber(700);
//		user1.setEmailID("tony@gmail.com");
//		user1.setAddress1("New York");
//		user1.setAddress2("USA");
//		userRepository.save(user1);
	}
}
