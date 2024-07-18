package com.algobattle.server.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algobattle.server.entity.Contest;
import com.algobattle.server.entity.Problem;
import com.algobattle.server.entity.Submission;
import com.algobattle.server.entity.User;
import com.algobattle.server.repository.ContestRankRepository;
import com.algobattle.server.repository.ContestRepository;
import com.algobattle.server.repository.ProblemRepository;
import com.algobattle.server.repository.SubmissionRepository;
import com.algobattle.server.repository.UserRepository;
import com.algobattle.server.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ContestRepository contestRepository;

	@Autowired
	private ContestRankRepository contestRankRepository;

	@Autowired
	private SubmissionRepository submissionRepository;
	
	@Autowired
	private ProblemRepository problemRepository;

	//done
	@Override
	public void registerUser(User user) {
		try {
			String userEmail = user.getEmail();
			String username = user.getUsername();
			Optional<User> foundUser = userRepository.findByUserEmail(userEmail);

			if (foundUser.isEmpty())
				foundUser = userRepository.findByUsername(username);

			if (foundUser.isEmpty()) {
				userRepository.save(user);
				log.warn("User with email {} successfully registered", userEmail);
			} else {
				log.info("email already in use", userEmail);
				throw new RuntimeException(username + " user already exists!");
			}
		} catch (Exception e) {
			log.error("user registration failed", e.getMessage());
			throw e;
		}
	}

	//done
	@Override
	public Optional<User> loginUser(String username, String password) {
		try {
			Optional<User> foundUser = userRepository.findByUsername(username);
			if (foundUser.isPresent()) {
				String foundUserPassword = foundUser.get().getPassword();
				if (password.equals(foundUserPassword)) {
					return foundUser;
				} else {
					log.info("Wrong password for the user {}", username);
					return Optional.empty();
				}
			} else {
				log.info("User with username {} doesn't exists");
				throw new RuntimeException("user with username " + username + " doesn't exists");
			}
		} catch (Exception e) {
			log.error("Error logging in for user {}: {}", username, e.getMessage());
			throw e;
		}
	}

	//done
	@Override
	public Optional<User> getUser(UUID userId) {
		try {
			Optional<User> foundUser = userRepository.findById(userId);
			if (foundUser.isPresent()) {
				log.info("user found successfully");
				return foundUser;
			} else {
				log.warn("User with specific user id {} doesn't exists", userId);
				return Optional.empty();
			}
		} catch (Exception e) {
			log.error("Error getting user with user id: {}", userId);
			throw e;
		}
	}

	// this will happen only after login
	// check this service once for logging the score gained in a single contest
	@Override
	public void participateInLiveContest(Long contestId, UUID userId) {
		try {
			Optional<Contest> contest = contestRepository.findById(contestId);
			if (contest.get().getHidden().equals(false)) {
				List<Problem> problems = contest.get().getProblems();
				Integer score = 0;
				for (Problem problem : problems) {
					// will return how much score you got from some problem
					UUID problemId = problem.getProblemId();
					score = solveProblem(problemId, userId, contestId);
				}
				updateUserRating(userId, score);
				log.info("Final score obtained after contest is {} for user {}", score, userId);
			} else {
				// just solve problems of the contest
				Integer score = 0;
				if (contest.isPresent()) {
					List<Problem> problems = contest.get().getProblems();
					for (Problem problem : problems) {
						UUID problemId = problem.getProblemId();
						score = solveProblem(problemId, userId, contestId);
					}
				}
			}
		} catch (Exception e) {
			log.error("Error joining contest {}", contestId, e.getMessage());
			throw e;
		}
	}

	@Override
	public Boolean solveProblem(UUID problemId, UUID userId) {
		try {
			Optional<Problem> foundProblem = problemRepository.findById(problemId);
			if(foundProblem.isPresent()) {
				Integer score =0;
				 score = solveProblem(problemId,userId);
				if(score>0) {
					log.info("Problem {} solved sucessfully by user: {}",problemId,userId);
				}
				else {
					log.warn("user {} failed to solve problem {}",userId,problemId );
				}
			}
			else {
				log.warn("Problem with problem id {} doesn't exists",problemId);
			}
		}
		catch(Exception e) {
			log.error("Error getting problem for user: {}",userId,e.getMessage());
		}
	}

	@Override
	public Long getContestRank(Long contestId, UUID userId) {
		try {
			Optional<Contest> foundContest = contestRepository.findById(contestId);
			Optional<User> foundUser = userRepository.findById(userId);

			if (foundContest.isPresent() && foundUser.isPresent()) {
				Long rank = contestRepository.findContestRank(contestId, userId);
				return rank;
			} else {
				log.warn("Error getting contest rank for user {} with contest id {}", userId, contestId);
				return 0L;
			}
		} catch (Exception e) {
			log.error("Error getting contest rank for user: {}", userId, e.getMessage());
			throw e;
		}
	}

	@Override
	public List<User> getWorldRank() {
		try {
			List<User> worldRanks = userRepository.findAll();
			Comparator<User> sortedRankings = Comparator.comparing(User::getRating).reversed();
			worldRanks.sort(sortedRankings);
			log.info("Successfullly fetched the world rankings");
			return worldRanks;
		} catch (Exception e) {
			log.error("Error getting world ranks");
			throw e;
		}
	}

	// for this we will also assume that user already exists
	@Override
	public List<Submission> getAllUserSubmission(UUID userId) {
		try {
			List<Submission> allSubmission = submissionRepository.findSubmissionForUser(userId);
			if (allSubmission.isEmpty()) {
				log.warn("No submissions were made for the user: {}", userId);
				return allSubmission;
			} else {
				log.info("Sucessfully fetched all submissions for the user: {}", userId);
				return allSubmission;
			}
		} catch (Exception e) {
			log.error("Error getting All user submission");
			throw e;
		}
	}

	// we will do this if the problem already exists and user is already logged in
	@Override
	public List<Submission> getSubmissionForProblem(UUID problemId, UUID userId) {
		try {
			list<Submission> userSubmissions = submissionRepository.getSubmissionForUser(problemId, userId);
		} catch (Exception e) {
			log.error("Error getting submissions for problem: {}", problemId, e.getMessage());
			throw e;
		}
		return null;
	}

}
