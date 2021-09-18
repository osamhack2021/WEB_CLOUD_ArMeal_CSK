package com.api.domain;

import java.sql.Timestamp;

public class Group {
    private long id;
	private String name;
	private Timestamp created_at;
    private Timestamp deleted_at;
    private boolean is_deleted;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getIsDeleted() {
		return is_deleted;
	}
	public void setIsDeleted(Boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	public Timestamp getdeletedAt() {
		return deleted_at;
	}
	public void setDeletedAt(Timestamp deleted_at) {
		this.deleted_at = deleted_at;
	}
	public Timestamp getCreatedAt() {
		return created_at;
	}
	public void setCreatedAt(Timestamp created_at) {
		this.created_at = created_at;
	}
}
