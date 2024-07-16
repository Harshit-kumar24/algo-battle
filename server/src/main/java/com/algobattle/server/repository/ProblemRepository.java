package com.algobattle.server.repository;

import com.algobattle.server.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProblemRepository extends JpaRepository<Problem, UUID> {

}


