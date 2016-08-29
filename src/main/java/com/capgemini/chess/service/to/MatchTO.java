package com.capgemini.chess.service.to;

import java.util.Date;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.enums.GameArbitration;


/**
 * transport objects between service of Match and Controller
 * 
 * @author DOLESIEJ
 *
 */
public class MatchTO {
	
	private Long id;
	private UserEntity player;
	private UserEntity opponent;
	private GameArbitration gameArbitration;
	private boolean gameFinished;
	private boolean onMovePlayer;
	private Date date;
	
	public MatchTO() {
	}

	public MatchTO(Long id, UserEntity player, UserEntity opponent, GameArbitration gameArbitration,
			boolean gameFinished, boolean onMovePlayer, Date date) {
		this.id = id;
		this.player = player;
		this.opponent = opponent;
		this.gameArbitration = gameArbitration;
		this.gameFinished = gameFinished;
		this.onMovePlayer = onMovePlayer;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getPlayer() {
		return player;
	}

	public void setPlayer(UserEntity player) {
		this.player = player;
	}

	public UserEntity getOpponent() {
		return opponent;
	}

	public void setOpponent(UserEntity opponent) {
		this.opponent = opponent;
	}

	public GameArbitration getGameArbitration() {
		return gameArbitration;
	}

	public void setGameArbitration(GameArbitration gameArbitration) {
		this.gameArbitration = gameArbitration;
	}

	public boolean isGameFinished() {
		return gameFinished;
	}

	public void setGameFinished(boolean gameFinished) {
		this.gameFinished = gameFinished;
	}

	public boolean isOnMovePlayer() {
		return onMovePlayer;
	}

	public void setOnMovePlayer(boolean onMovePlayer) {
		this.onMovePlayer = onMovePlayer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
