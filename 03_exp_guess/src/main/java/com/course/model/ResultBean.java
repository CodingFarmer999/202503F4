package com.course.model;

public class ResultBean {
	/** 本次猜的數字 */
	private String guessNum;
	
	/** 幾A幾B */
	private String resultDisplay;

	/** 幾A */
	private Integer aCount;

	/** 幾B */
	private Integer bCount;

	public String getGuessNum() {
		return guessNum;
	}

	public void setGuessNum(String guessNum) {
		this.guessNum = guessNum;
	}

	public Integer getaCount() {
		return aCount;
	}

	public void setaCount(Integer aCount) {
		this.aCount = aCount;
	}

	public Integer getbCount() {
		return bCount;
	}

	public void setbCount(Integer bCount) {
		this.bCount = bCount;
	}

	public String getResultDisplay() {
		return resultDisplay;
	}

	public void setResultDisplay(String resultDisplay) {
		this.resultDisplay = resultDisplay;
	}
}
