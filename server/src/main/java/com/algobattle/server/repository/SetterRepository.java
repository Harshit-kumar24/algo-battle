package com.algobattle.server.repository;

import com.algobattle.server.entity.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SetterRepository extends JpaRepository<Setter, UUID> {

}