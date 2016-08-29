package com.capgemini.chess.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.MatchDao;
import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.enums.GameArbitration;
import com.capgemini.chess.service.MatchService;

/**
 * implementation of MatchService
 * 
 * @findAllMatchesNotFinished get list of matches during play
 * @author DOLESIEJ
 *
 */
@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchDao matchDao;
	private final static int HOURS = 24;
	private final static int MINUTES = 60;
	private final static int SECONDS = 60;
	private final static int NANO_SECONDS = 1000;
	private final static int DAY_IN_NANOSECONDS = HOURS * MINUTES * SECONDS * NANO_SECONDS;
	
	private Date yesterday = new Date(System.currentTimeMillis() - DAY_IN_NANOSECONDS);

	public MatchServiceImpl() {
	}

	@Override
	public List<MatchEntity> findAllMatchesNotFinished() {
		return matchDao.findAllMatchesNotFinished();
	}
	
	/**
	 * method arbitrate match if start time of match is grater than specific period 
	 * 
	 * @param match
	 * @return match
	 */
	
	private MatchEntity arbitrateMatch(MatchEntity match) {
		if (match.getDate().before(yesterday))
			if (match.isOnMovePlayer()) {
				match.setGameArbitration(GameArbitration.LOST);
			} else {
				match.setGameArbitration(GameArbitration.WON);
			}
		return match;
	}

	@Override
	public List<MatchEntity> arbitrateMatches(List<MatchEntity> matches) {
		matches.stream().filter(m -> m.getGameArbitration() == GameArbitration.NONE).forEach((m) ->	arbitrateMatch(m));
		return matches;
	}
	
	@Override
	public MatchEntity updateMatch(MatchEntity match) {
		return matchDao.update(match);
	}

	@Override
	public MatchEntity findMatchById(Long matchId) {
		return matchDao.findOne(matchId);
	}

	@Override
	public List<MatchEntity> findAllMatches() {
		return matchDao.findAll();
	}

	@Override
	public void deleteMatchById(Long matchId) {
		matchDao.delete(matchId);
	}

	@Override
	public MatchEntity addMatch(MatchEntity match) {
		return matchDao.save(match);
	}

	

}
