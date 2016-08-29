package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;
/**
 * @findAllMatchesNotFinished get list of matches during play
 * @save sends result of unfinished matches by arbitrate if player did move for some period
 * @author DOLESIEJ
 *
 */
public interface MatchService {

	
	List<MatchEntity> findAllMatchesNotFinished();
	List<MatchEntity> arbitrateMatches(List<MatchEntity> matches);
	MatchEntity updateMatch(MatchEntity match);
	MatchEntity findMatchById(Long matchId);
	List<MatchEntity> findAllMatches();
	void deleteMatchById(Long matchId);
	MatchEntity addMatch(MatchEntity match);
}
