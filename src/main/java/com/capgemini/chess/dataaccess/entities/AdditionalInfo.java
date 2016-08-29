package com.capgemini.chess.dataaccess.entities;

import javax.persistence.Embeddable;

@Embeddable
public class AdditionalInfo {

	private String createdBy;
	private String modyfiedBy;
	
	public AdditionalInfo() {
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModyfiedBy() {
		return modyfiedBy;
	}

	public void setModyfiedBy(String modyfiedBy) {
		this.modyfiedBy = modyfiedBy;
	}
}
