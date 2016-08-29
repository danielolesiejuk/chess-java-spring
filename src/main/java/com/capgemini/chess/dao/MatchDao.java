package com.capgemini.chess.dao;

import java.util.List;

import com.capgemini.chess.dataaccess.entities.MatchEntity;

/**
 * @findAllMatchesNotFinished get list of matches during play
 * @save sends result of unfinished matches by arbitrate if player did not move for some period of time
 * @author DOLESIEJ
 *
 */
public interface MatchDao extends Dao <MatchEntity, Long>{
	
	List<MatchEntity> findAllMatchesNotFinished();
}
