package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.service.UserService;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.UserProfileTO;
/**
 * implementation of UserService
 * @findPlayerByLogin service for find player by login form DB
 * @findPlayerByName service for find player by name form DB
 * @sendChallengeToOpponent service for return a list of players to be challenged (manual choice)
 * @author DOLESIEJ
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserProfileTO findPlayerByLogin(String login) {
		return UserProfileMapper.map(userDao.findPlayerByLogin(login));
	}

	@Override
	public UserProfileTO findPlayerByName(String name) {
		return UserProfileMapper.map(userDao.findPlayerByName(name));
	}

	@Override
	public UserProfileTO sendChallengeToOpponent(UserProfileTO opponent) {
		return UserProfileMapper.map(userDao.sendChallengeToOpponent(UserProfileMapper.map(opponent)));
	}
	
	public UserProfileTO deletePlayerByLogin(String login) {
		return UserProfileMapper.map(userDao.deletePlayerByLogin(login));
	}

}
