package com.example.demo.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;



public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserName(String userName);
}
