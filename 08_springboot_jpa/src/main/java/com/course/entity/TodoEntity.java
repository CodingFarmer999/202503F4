package com.course.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TODO")
public class TodoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TODO_SEQ_GENERATOR")
	@SequenceGenerator(name = "TODO_SEQ_GENERATOR", sequenceName = "TODO_SEQ", allocationSize = 1)
	private Long id;

	@Column
	private String title;

	@Column(name = "DUE_DATE")
	private Date dueDate;
	
	@Column
	private Integer status;
	
	@Column
	private String memo;
	
	@Column
	private Long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "TodoEntity [id=" + id + ", title=" + title + ", dueDate=" + dueDate + ", status=" + status + ", memo="
				+ memo + ", userId=" + userId + "]";
	}


}
