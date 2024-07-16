package com.algobattle.server.repository;

import com.algobattle.server.entity.Contest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestRepository extends JpaRepository<Contest, Long> {

}
