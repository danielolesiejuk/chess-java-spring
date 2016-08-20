package com.capgemini.chess.service.impl;

import java.time.LocalDate;
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
 * @save sends result of unfinished matches by arbitrate if player did move for
 *       some period
 * @author DOLESIEJ
 *
 */
@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchDao matchDao;
	
	private LocalDate now = LocalDate.now();

	public MatchServiceImpl() {

	}

	@Override
	public List<MatchEntity> findAllMatchesNotFinished() {
		return matchDao.findAllMatchesNotFinished();
	}

	@Override
	public void save(List<MatchEntity> matches) {
		matchDao.save(matches);
	}

	/**
	 * method arbitrate match if start time of match is grater than specific period 
	 * 
	 * @param match
	 * @return match
	 */
	private MatchEntity arbitrateMatch(MatchEntity match) {
		if (match.getMatch().getLocalDate().isBefore(now))
			if (match.getMatch().isOnMovePlayer()) {
				match.getMatch().setGameArbitration(GameArbitration.LOST);
			} else {
				match.getMatch().setGameArbitration(GameArbitration.WON);
			}
		return match;
	}

	@Override
	public List<MatchEntity> arbitrateMatches(List<MatchEntity> matches) {
		matches.stream().filter(m -> m.getMatch().getGameArbitration() == GameArbitration.NONE).forEach((m) -> arbitrateMatch(m));
		return matches;
	}

}
