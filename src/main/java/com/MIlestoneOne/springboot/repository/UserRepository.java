package com.MIlestoneOne.springboot.repository;

import com.MIlestoneOne.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
   //all the crud operation are done through This interface.
}
