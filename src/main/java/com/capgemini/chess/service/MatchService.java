package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.dataaccess.entities.MatchEntity;
/**
 * @findAllMatchesNotFinished get list of matches during play
 * @save sends result of unfinished matches by arbitrate if player did move for some period
 * @author DOLESIEJ
 *
 */
public interface MatchService {

	List<MatchEntity> findAllMatchesNotFinished();
	List<MatchEntity> arbitrateMatches(List<MatchEntity> matches);
	void save(List<MatchEntity> allArbitratedMatches);
}
