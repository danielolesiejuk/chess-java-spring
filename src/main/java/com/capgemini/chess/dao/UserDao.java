package com.capgemini.chess.dao;

import com.capgemini.chess.dataaccess.entities.UserEntity;
/**
 * @findPlayerByLogin find player by login form DB
 * @findPlayerByName find player by name form DB
 * @sendChallengeToOpponent save a list of players to be challenged ( of manual choice)
 * @author DOLESIEJ
 *
 */
public interface UserDao {
	
	UserEntity findPlayerByLogin(String login);
	
	UserEntity findPlayerByName(String name);
	
	UserEntity sendChallengeToOpponent(UserEntity opponent);
	
	UserEntity deletePlayerByLogin(String login);
     
}
