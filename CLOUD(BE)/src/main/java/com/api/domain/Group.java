package com.api.domain;

import java.sql.Timestamp;

import io.swagger.annotations.ApiModelProperty;


public class Group {
	
	@ApiModelProperty(hidden = true)
    private long id;
	
	@ApiModelProperty(notes = "부대명", example = "1급양대")
	private String name;
	
	@ApiModelProperty(hidden = true)
	private Timestamp created_at;

	@ApiModelProperty(hidden = true)
	private Timestamp deleted_at;

	@ApiModelProperty(hidden = true)
    private boolean is_deleted;
	

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreated_at() {
		return this.created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getDeleted_at() {
		return this.deleted_at;
	}

	public void setDeleted_at(Timestamp deleted_at) {
		this.deleted_at = deleted_at;
	}

	public boolean isIs_deleted() {
		return this.is_deleted;
	}

	public boolean getIs_deleted() {
		return this.is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", name='" + getName() + "'" +
			", created_at='" + getCreated_at() + "'" +
			", deleted_at='" + getDeleted_at() + "'" +
			", is_deleted='" + isIs_deleted() + "'" +
			"}";
	}
	
}
