package com.capgemini.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.service.ChallengeService;

@Service
public class ChallengeServiceImpl implements ChallengeService {
	
	@Autowired
	private ChallengeDao challengeDao;

	@Override
	public ChallengeEntity sendChallengeToOpponent(ChallengeEntity challenge) {
		return challengeDao.save(challenge);
	}

	@Override
	public void cancelChallenge(ChallengeEntity challenge) {
		challengeDao.delete(challenge);
	}

	@Override
	public ChallengeEntity acceptChallenge(ChallengeEntity challenge) {
		challenge.setAccepted(true);
		return challengeDao.update(challenge);
	}

	@Override
	public ChallengeEntity rejectChallenge(ChallengeEntity challenge) {
		challenge.setAccepted(false);
		return challengeDao.update(challenge);
	}

	@Override
	public ChallengeEntity findChallenge(Long challengeId) {
		return challengeDao.findOne(challengeId);
	}
	
	@Override
	public List<ChallengeEntity> findAllChallenges() {
		return challengeDao.findAll();
	}

}
