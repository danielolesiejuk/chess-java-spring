package com.capgemini.chess.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.facade.UserFacade;
import com.capgemini.chess.service.ChallengeService;
import com.capgemini.chess.service.UserService;
import com.capgemini.chess.service.mapper.ChallengeMapper;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
public class UserFacadeImpl implements UserFacade {
	
	@Autowired
	private UserService userRepository;
	
	@Autowired
	private ChallengeService challengeRepository;
	
	@Override
	public UserProfileTO findPlayerByLogin(String login){
		UserEntity entity = userRepository.findPlayerByLogin(login);
		return UserProfileMapper.map(entity);
	}
	
	@Override
	public UserProfileTO findPlayerByName(String name){
		UserEntity entity = userRepository.findPlayerByName(name);
		return UserProfileMapper.map(entity);
	}
	
	@Override
	public ChallengeTO sendChallengeToOpponent(ChallengeEntity challenge){
		ChallengeEntity entity = challengeRepository.sendChallengeToOpponent(challenge);
		return ChallengeMapper.map(entity);
	}
	
	@Override
	public void deletePlayerByLogin(Long loginId){
		userRepository.deletePlayerByLogin(loginId);
	}
}
