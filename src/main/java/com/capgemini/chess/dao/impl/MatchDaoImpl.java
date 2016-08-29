package com.capgemini.chess.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.MatchDao;
import com.capgemini.chess.dataaccess.entities.MatchEntity;

/**
 * implementation of MatchDao
 * 
 * @findAllMatchesNotFinished get list of matches during play
 * @save sends result of unfinished matches by arbitrate if player did move for
 *       some period
 * @author DOLESIEJ
 *
 */
@Repository
public class MatchDaoImpl extends AbstractDao<MatchEntity, Long> implements MatchDao {

	public MatchDaoImpl() {
	}

	@Override
	public List<MatchEntity> findAllMatchesNotFinished() {
		TypedQuery<MatchEntity> query = entityManager.createQuery(
				"select match from MatchEntity match where match.gameFinished = 0 and match.gameArbitration = 'NONE' ",
				MatchEntity.class);
		return query.getResultList();
		
	}

}
