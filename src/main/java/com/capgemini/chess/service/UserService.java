package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.dataaccess.entities.UserEntity;
/**
 * @findPlayerByLogin service for find player by login form DB
 * @findPlayerByName service for find player by name form DB
 * @sendChallengeToOpponent service for save a list of players to be challenged (of manual choice)
 * @author DOLESIEJ
 *
 */
public interface UserService {

	UserEntity findPlayerByLogin(String login);
	UserEntity findPlayerByName(String name);
	List<UserEntity> findAllPlayers();
	void deletePlayerByLogin(Long loginId);
	UserEntity addPlayer(UserEntity user);
	UserEntity editPlayer(UserEntity user);
}
