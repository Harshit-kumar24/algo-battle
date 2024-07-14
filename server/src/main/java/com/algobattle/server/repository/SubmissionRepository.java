package com.algoBattle.server.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algoBattle.server.entity.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, UUID> {

}
