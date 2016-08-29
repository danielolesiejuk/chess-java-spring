package com.capgemini.chess.dataaccess.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostUpdate;
import javax.persistence.Version;

@MappedSuperclass
public class BaseEntity {

	@Column(name = "modyfied_at", columnDefinition = "Timestamp default CURRENT_TIMESTAMP")
	private Date modyfiedAt;

	@Column(name = "created_at", columnDefinition = "Timestamp default CURRENT_TIMESTAMP")
	private Date createdAt;

	@Version
	@Column(name = "version", columnDefinition = "integer DEFAULT 1",  nullable = false)
	private Long version = 1L;

	public Date getModyfiedAt() {
		return modyfiedAt;
	}
	
	@PostUpdate
	public void setModyfiedAt() {
		this.modyfiedAt = new Date(System.currentTimeMillis());
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	
}
