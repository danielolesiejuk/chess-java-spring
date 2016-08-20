package com.capgemini.chess;

import java.time.LocalDate;

import com.capgemini.chess.enums.GameArbitration;

/**
 * represent virtual/temporary information about status of played match between two players
 * @author DOLESIEJ
 *
 */
public class Match {

	private String player;
	private String oponent;
	private GameArbitration gameArbitration;
	private boolean gameFinished;
	private boolean onMovePlayer;
	private LocalDate localDate;


	public Match(String player, String oponent, GameArbitration gameArbitration, boolean gameFinished, boolean onMovePlayer, LocalDate localDate) {
		super();
		this.player = player;
		this.oponent = oponent;
		this.gameArbitration = gameArbitration;
		this.gameFinished = gameFinished;
		this.onMovePlayer = onMovePlayer;
		this.setLocalDate(localDate);
	}
	
	public String getPlayer() {
		return player;
	}

	public String getOponent() {
		return oponent;
	}

	public boolean isOnMovePlayer() {
		return onMovePlayer;
	}

	public boolean isGameFinished() {
		return gameFinished;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public GameArbitration getGameArbitration() {
		return gameArbitration;
	}

	public void setGameArbitration(GameArbitration gameArbitration) {
		this.gameArbitration = gameArbitration;
	}
}
