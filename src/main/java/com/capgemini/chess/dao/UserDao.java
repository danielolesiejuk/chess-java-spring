package com.capgemini.chess.dao;

import java.util.List;

import com.capgemini.chess.dataaccess.entities.UserEntity;
/**
 * @findPlayerByLogin find player by login form DB
 * @findPlayerByName find player by name form DB
 * @author DOLESIEJ
 *
 */
public interface UserDao extends Dao <UserEntity, Long>{
	
	UserEntity findPlayerByLogin(String login);
	UserEntity findPlayerByName(String name);
     
}
