package com.algoBattle.server.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algoBattle.server.entity.ContestRank;

public interface ContestRankRepository extends JpaRepository<ContestRank, UUID> {

}
