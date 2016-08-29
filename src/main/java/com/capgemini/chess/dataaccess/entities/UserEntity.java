package com.capgemini.chess.dataaccess.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity used to transfer User data by Dao
 * @author DOLESIEJ
 *
 */
@Entity
@Table(name = "USER")
public class UserEntity  extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "login", length = 45, nullable = false)
	private String login;
	
	@Column(name = "name", length = 45, nullable = false)
	private String name;

	@Embedded
	private AdditionalInfo additionalInfo;
	
	@OneToMany(mappedBy = "player",cascade = CascadeType.REMOVE)
    private Collection<MatchEntity> assignmentsPlayer; 
	
	@OneToMany(mappedBy = "opponent",cascade = CascadeType.REMOVE)
    private Collection<MatchEntity> assignmentsOpponent; 
	
	@OneToMany(mappedBy = "challenger",cascade = CascadeType.REMOVE)
    private Collection<ChallengeEntity> assignmentsChallenger; 
	
	@OneToMany(mappedBy = "challenged",cascade = CascadeType.REMOVE)
    private Collection<ChallengeEntity> assignmentsChallenged; 
		
	public UserEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(AdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	
}
