package com.algobattle.server.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algobattle.server.entity.Submission;
import com.algobattle.server.entity.User;
import com.algobattle.server.repository.UserRepository;
import com.algobattle.server.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void registerUser(User user) {	
		try {
			String userEmail = user.getEmail();
			String username = user.getUsername();
			Optional<User> foundUser = userRepository.findByUserEmail(userEmail);

			if(foundUser.isEmpty()) foundUser = userRepository.findByUsername(username);

			if(foundUser.isEmpty()) {
				userRepository.save(user);
				log.info("User with email {} successfully registered",userEmail);
			}
			else {
				log.info("email already in use",userEmail);
				throw new RuntimeException(username+" user already exists!");
			}
		}
		catch(Exception e) {
			log.error("user registration failed",e.getMessage());
			throw e;
		}
	}

	@Override
	public Optional<User> loginUser(String username, String password) {
			try {
				Optional<User> foundUser = userRepository.findByUsername(username);
				if(foundUser.isPresent()) {
					String foundUserPassword = foundUser.get().getPassword();
					if(password.equals(foundUserPassword)) {
						return foundUser;
					}
					else {
						log.info("Wrong password for the user {}",username);
					}
				}
				else {
					log.info("User with username {} doesn't exists");
					throw new RuntimeException("user with username "+username+" doesn't exists");
				}
			}
			catch(Exception e) {
				log.error("Error logging in for user {}: {}",username,e.getMessage());
				throw e;
			}
		return Optional.empty(); 
		}


	@Override
	public User getUser(UUID userId) {
		
		return null;
	}

	@Override
	public void participateInLiveContest(Long contestId, UUID userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean solveProblem(UUID problemId, UUID userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getContestRank(Long contestId, UUID userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getWorldRank() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Submission> getAllUserSubmission() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Submission> getSubmissionForProblem(UUID problemId, UUID userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
