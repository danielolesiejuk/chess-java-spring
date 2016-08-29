package com.capgemini.chess.facade;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.UserProfileTO;

public interface UserFacade {

	UserProfileTO findPlayerByLogin(String login);
	UserProfileTO findPlayerByName(String name);
	ChallengeTO sendChallengeToOpponent(ChallengeEntity challenge);
	void deletePlayerByLogin(Long loginId);

}
