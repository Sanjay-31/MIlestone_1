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

	}
}
