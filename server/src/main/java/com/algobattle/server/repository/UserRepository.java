package com.algobattle.server.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.algobattle.server.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {
	
	@Query("SELECT u FROM User u WHERE u.email = :email")
	Optional<User> findByUserEmail(@Param("email") String email);
	
	@Query("SELECT u FROM User u WHERE u.username = :username ")
	Optional<User> findByUsername(@Param("user") String username);
}
