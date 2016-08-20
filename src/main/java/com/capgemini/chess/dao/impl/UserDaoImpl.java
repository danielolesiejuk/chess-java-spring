package com.capgemini.chess.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class UserDaoImpl implements UserDao {
	private final Set<UserEntity> allUsers = new HashSet<UserEntity>();
	private final List<UserEntity> challengedUsers = new ArrayList<UserEntity>();

	public UserDaoImpl() {
		addTestUsers();
	}

	@Override
	public UserEntity findPlayerByLogin(String login) throws IllegalArgumentException {
		if (login == null) {
			throw new IllegalArgumentException("Wrong login or login not found");
		}
		return allUsers.stream().filter(u -> u.getLogin().equals(login)).findAny().orElse(null);
	}

	@Override
	public UserEntity findPlayerByName(String name) throws IllegalArgumentException {
		UserEntity result = allUsers.stream().filter((u) -> u.getName().equals(name)).findAny().orElse(null);
		if (result.getName().equals(null) || name.equals(null))
			throw new IllegalArgumentException("Wrong name or name not found");
		else
			return result;
	}

	@Override
	public UserEntity sendChallengeToOpponent(UserEntity opponent) {
		challengedUsers.add(opponent);
		return opponent;
	}

	public List<UserEntity> getChallengedUsers() {
		return challengedUsers;
	}
	
	public UserEntity deletePlayerByLogin(String login) throws IllegalArgumentException {
		if (login == null) {
			throw new IllegalArgumentException("Wrong login or login not found");
		}
		allUsers.remove(login);
		return allUsers.stream().filter(u -> u.getLogin().equals(login)).findAny().orElse(null);
	}

	private void addTestUsers() {
		allUsers.add(new UserEntity(1L, "Romeo", "Wiliam"));
		allUsers.add(new UserEntity(2L, "Opium", "Hanna"));
		allUsers.add(new UserEntity(3L, "Odyseusz", "Jan"));
		allUsers.add(new UserEntity(4L, "Awantura", "Edmund"));
		allUsers.add(new UserEntity(5L, "Fantomas", "Zbigniew"));
		allUsers.add(new UserEntity(6L, "Zemsta", "Aleksander"));
	}
}
