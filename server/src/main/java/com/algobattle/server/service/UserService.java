package com.algobattle.server.service;

import java.util.List;
import java.util.UUID;

import com.algobattle.server.entity.Submission;
import com.algobattle.server.entity.User;

public interface UserService {
	
		void registerUser(User user);

		User loginUser(String username,String password);
		
		User getUser(UUID userId);
		
		void participateInLiveContest(Long contestId,UUID userId);
		
		Boolean solveProblem(UUID problemId,UUID userId);
		
		Long getContestRank(Long contestId,UUID userId);
		
		List<User> getWorldRank();
		
		List<Submission> getAllUserSubmission();
		
		List<Submission> getSubmissionForProblem(UUID problemId,UUID userId);
}
