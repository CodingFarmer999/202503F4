package com.course.model;

public class TodoVo {

	/** 鍵值 */
	private Long id;
	
	/** 標題 */
	private String title;
	
	/** 到期日 */
	private String dueDate;
	
	/** 狀態 */
	private String status;
	
	/** 狀態呈現 */
	private String statusDisp;
	
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

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusDisp() {
		return statusDisp;
	}

	public void setStatusDisp(String statusDisp) {
		this.statusDisp = statusDisp;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
