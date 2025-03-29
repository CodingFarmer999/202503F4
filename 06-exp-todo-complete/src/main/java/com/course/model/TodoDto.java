package com.course.model;

import java.util.Date;

public class TodoDto {

	/** 鍵值 */
	private Long id;
	
	/** 使用者鍵值 */
	private Long userId;
	
	/** 標題 */
	private String title;
	
	/** 到期日 */
	private Date dueDate;
	
	/** 狀態 */
	private Integer status;
	
	/** 備註 */
	private String memo;
	
	/** 使用者名稱 */
	private String username;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
