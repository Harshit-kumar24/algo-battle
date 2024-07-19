package com.algobattle.server.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.algobattle.server.entity.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, UUID> {

	
	@Query("SELECT u FROM Submission u WHERE u.user.userId= :userId")
	List<Submission> findSubmissionsForUser(@Param("userId") UUID userId);
	
	@Query("SELECT u FROM Submission u WHERE u.user.userId= :userId AND u.problem.problemId= :problemId")
	List<Submission> getSubmissionForUserForProblem(@Param("userId") UUID  userId,@Param("problemId") UUID problemId);
}
