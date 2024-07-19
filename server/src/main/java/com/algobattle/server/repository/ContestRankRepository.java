package com.algobattle.server.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.algobattle.server.entity.ContestRank;

public interface ContestRankRepository extends JpaRepository<ContestRank, UUID> {

	@Query("SELECT u FROM ContestRank u WHERE u.rankContest.contestId = :contestId AND u.user.userId = :userId")
	public Long findContestRank(@Param("contestId") Long contestId, @Param("userId") UUID userId);
}