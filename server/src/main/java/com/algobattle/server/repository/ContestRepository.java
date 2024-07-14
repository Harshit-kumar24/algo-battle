package com.algoBattle.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algoBattle.server.entity.Contest;

public interface ContestRepository extends JpaRepository<Contest, Long> {

}
