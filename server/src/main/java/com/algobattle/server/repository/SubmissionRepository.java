package com.algobattle.server.repository;

import com.algobattle.server.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubmissionRepository extends JpaRepository<Submission, UUID> {

}
