package com.algobattle.server.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algobattle.server.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
