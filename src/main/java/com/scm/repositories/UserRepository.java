package com.scm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entity.User;

public interface UserRepository extends JpaRepository<User,String> {
	//extra method db relatedoperation
	//custom query methods
	//custom finder methods
	Optional<User> findByEmail(String email);
   Optional<User> findByEmailAndPassword(String email,String password);
}
