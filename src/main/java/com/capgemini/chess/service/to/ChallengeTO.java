package com.capgemini.chess.service.to;

import java.util.Date;

import com.capgemini.chess.dataaccess.entities.UserEntity;

public class ChallengeTO {

	private Long id;
	private UserEntity challenger;
	private UserEntity challenged;
	private Date date;
	private boolean accepted;

	public ChallengeTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getChallenger() {
		return challenger;
	}

	public void setChallenger(UserEntity challenger) {
		this.challenger = challenger;
	}

	public UserEntity getChallenged() {
		return challenged;
	}

	public void setChallenged(UserEntity challenged) {
		this.challenged = challenged;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

}
