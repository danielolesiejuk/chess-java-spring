package com.capgemini.chess.service;

import com.capgemini.chess.service.to.UserProfileTO;
/**
 * @findPlayerByLogin service for find player by login form DB
 * @findPlayerByName service for find player by name form DB
 * @sendChallengeToOpponent service for save a list of players to be challenged (of manual choice)
 * @author DOLESIEJ
 *
 */
public interface UserService {

	UserProfileTO findPlayerByLogin(String login);

	UserProfileTO findPlayerByName(String name);

	UserProfileTO sendChallengeToOpponent(UserProfileTO opponent);

	UserProfileTO deletePlayerByLogin(String login);
}
