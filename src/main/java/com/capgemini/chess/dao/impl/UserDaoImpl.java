package com.capgemini.chess.dao.impl;

import javax.persistence.TypedQuery;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.UserEntity;

/**
 * implementation of UserDAO
 * 
 * @findPlayerByLogin find player by login form DB
 * @findPlayerByName find player by name form DB
 * @sendChallengeToOpponent return a list of players to be challenged (manual
 *                          choice)
 * @author DOLESIEJ
 *
 */
@Repository
public class UserDaoImpl extends AbstractDao<UserEntity, Long> implements UserDao {

	public UserDaoImpl() {
	}

	@Override
	public UserEntity findPlayerByLogin(String login) throws EmptyResultDataAccessException {
		TypedQuery<UserEntity> query = entityManager.createQuery(
				"select user from UserEntity user where user.login = :login",
				UserEntity.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}

	@Override
	public UserEntity findPlayerByName(String name) throws EmptyResultDataAccessException {
		TypedQuery<UserEntity> query = entityManager.createQuery(
				"select user from UserEntity user where user.name = :name",
				UserEntity.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}

}
