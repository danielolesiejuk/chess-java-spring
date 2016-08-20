package com.capgemini.chess.dataaccess.entities;

/**
 * Entity used to transfer User data by Dao
 * @author DOLESIEJ
 *
 */
public class UserEntity  {

	private long id;
	private String login;
	private String name;

	public UserEntity() {
	}

	public UserEntity(long id, String login, String name) {
		super();
		this.id = id;
		this.login = login;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

}
