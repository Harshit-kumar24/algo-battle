package com.algobattle.server.repository;

import com.algobattle.server.entity.TestSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TestSubmissionRepository extends JpaRepository<TestSubmission, UUID> {

}