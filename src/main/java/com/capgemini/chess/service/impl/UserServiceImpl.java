package com.capgemini.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.UserService;
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
	public UserEntity findPlayerByLogin(String login) {
		return userDao.findPlayerByLogin(login);
	}

	@Override
	public UserEntity findPlayerByName(String name) {
		return userDao.findPlayerByName(name);
	}

	@Override
	public void deletePlayerByLogin(Long loginId) {
		userDao.delete(loginId);
	}
	
	@Override
	public UserEntity addPlayer(UserEntity user) {
		return userDao.save(user);
	}

	@Override
	public UserEntity editPlayer(UserEntity user) {
		return userDao.update(user);
	}

	@Override
	public List<UserEntity> findAllPlayers() {
		return userDao.findAll();
	}

}
