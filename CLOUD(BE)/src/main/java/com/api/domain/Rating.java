package com.api.domain;

import java.sql.Date;
import java.sql.Timestamp;

import io.swagger.annotations.ApiModelProperty;

public class Rating {

	public Rating() {}
	
	public Rating(long userId, Date date, long targetId, int targetType, long groupId, int rating, int badReason, int time) {
		this.User_id = userId;
		this.date = date;
		this.time = time;
		this.Target_id = targetId;
		this.Target_type = targetType;
		this.group_id = groupId;
		this.rating_data = rating;
		this.bad_reason = badReason;
	}

	@ApiModelProperty(hidden = true)
    private long id;

	@ApiModelProperty(notes = "급양대 부대번호", example = "5322")
    private long group_id;
	
	@ApiModelProperty(notes = "평가 날짜", example = "5322")
    private Date date;

	@ApiModelProperty(notes = "평가하는 시간(조,중,석)", example = "5322")
    private int time;
	
	@ApiModelProperty(notes = "유저 아이디", example = "1")
	private long User_id;

	@ApiModelProperty(notes = "대상 아이디", example = "1")
	private long Target_id;

	@ApiModelProperty(notes = "평가 유형\n1 : 메뉴\n2 : 일일 메뉴", example = "1")
	private int Target_type;

	@ApiModelProperty(notes = "평가 값\n5 : 좋음\n4 : 좋음\n3 : 보통\n2 : 나쁨\n1 : 아주 나쁨", example = "1")
    private int rating_data;

	@ApiModelProperty(notes = "매우나쁨 이유 \n1: 짜다, 2: 쓰다, 3: 맵다, 4: 달다, 5: 시다, 6: 싱겁다, 7: 식었다, 8: 양이적다", example = "1")
	private int bad_reason;

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

	public long getGroup_id() {
		return this.group_id;
	}

	public void setGroup_id(long group_id) {
		this.group_id = group_id;
	}

	public long getUser_id() {
		return this.User_id;
	}

	public void setUser_id(long User_id) {
		this.User_id = User_id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTime() {
		return this.time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public long getTarget_id() {
		return this.Target_id;
	}

	public void setTarget_id(long Target_id) {
		this.Target_id = Target_id;
	}

	public int getTarget_type() {
		return this.Target_type;
	}

	public void setTarget_type(int Target_type) {
		this.Target_type = Target_type;
	}

	public int getRating_data() {
		return this.rating_data;
	}

	public void setRating_data(int rating_data) {
		this.rating_data = rating_data;
	}

	public int getBad_reason() {
		return this.bad_reason;
	}

	public void setBad_reason(int bad_reason) {
		this.bad_reason = bad_reason;
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
			", group_id='" + getGroup_id() + "'" +
			", User_id='" + getUser_id() + "'" +
			", Target_id='" + getTarget_id() + "'" +
			", Target_type='" + getTarget_type() + "'" +
			", rating_data='" + getRating_data() + "'" +
			", bad_reason='" + getBad_reason() + "'" +
			", created_at='" + getCreated_at() + "'" +
			", deleted_at='" + getDeleted_at() + "'" +
			", is_deleted='" + isIs_deleted() + "'" +
			"}";
	}

	
}
