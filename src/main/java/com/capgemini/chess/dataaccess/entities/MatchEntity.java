package com.capgemini.chess.dataaccess.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.capgemini.chess.enums.GameArbitration;
/**
 * Entity used to transfer Match data by Dao
 * @author DOLESIEJ
 *
 */

@Entity
@Table(name = "MATCH_TBL")
public class MatchEntity extends BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private UserEntity player;
	
	@ManyToOne
	private UserEntity opponent;
	
	@Enumerated(EnumType.STRING)
	private GameArbitration gameArbitration;
	
	@Column(name = "game_finished", nullable = true)
	private boolean gameFinished;
	
	@Column(name = "on_move_player", nullable = true)
	private boolean onMovePlayer;
	
	@Column(name = "date", nullable = true)
	private Date date;
	
	@Embedded
	private AdditionalInfo additionalInfo;
	
	public MatchEntity()  {
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
	public AdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(AdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}
