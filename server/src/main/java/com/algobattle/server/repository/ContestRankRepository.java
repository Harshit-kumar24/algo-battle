package com.algobattle.server.repository;

import com.algobattle.server.entity.ContestRank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContestRankRepository extends JpaRepository<ContestRank, UUID> {

}