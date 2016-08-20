package com.capgemini.chess.dataaccess.entities;

import com.capgemini.chess.Match;
/**
 * Entity used to transfer Match data by Dao
 * @author DOLESIEJ
 *
 */
public class MatchEntity {

	private long id;
	private Match match;
	
	public MatchEntity()  {
	}
	
	public MatchEntity(long id, Match match) {
		this.setId(id);
		this.match = match;
	}
	
	public Match getMatch() {
		return match;
	}


	public void setMatch(Match match) {
		this.match = match;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
