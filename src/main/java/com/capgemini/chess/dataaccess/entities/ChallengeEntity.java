package com.capgemini.chess.dataaccess.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Challenges")
public class ChallengeEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private UserEntity challenger;
	
	@ManyToOne
	private UserEntity challenged;
	
	@Column(name = "date", columnDefinition = "Timestamp default CURRENT_TIMESTAMP")
	private Date date;
	
	@Column(name = "accepted", nullable = true)
	private boolean accepted;
	
	@Embedded
	private AdditionalInfo additionalInfo;

	public ChallengeEntity() {
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

	public AdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(AdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

}
