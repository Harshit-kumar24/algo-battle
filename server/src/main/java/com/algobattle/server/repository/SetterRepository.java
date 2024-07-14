package com.algoBattle.server.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algoBattle.server.entity.Setter;

public interface SetterRepository extends JpaRepository<Setter, UUID> {

}
