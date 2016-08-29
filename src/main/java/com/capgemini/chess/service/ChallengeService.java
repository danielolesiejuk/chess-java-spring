package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;

/**
 * 
 * @author DOLESIEJ
 *
 */
public interface ChallengeService {
	
	ChallengeEntity sendChallengeToOpponent(ChallengeEntity challenge);
	void cancelChallenge (ChallengeEntity challenge);
	ChallengeEntity acceptChallenge (ChallengeEntity challenge);
	ChallengeEntity rejectChallenge (ChallengeEntity challenge);
	ChallengeEntity findChallenge (Long challengeId);
	List<ChallengeEntity> findAllChallenges ();
}
