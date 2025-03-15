package com.course.model;

import java.util.ArrayList;
import java.util.List;

public class GameInfo {

	/** 本次答案 */
	private String answer;
	
	/** 猜測歷程 */
	private List<ResultBean> guessHistory = new ArrayList<>();

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<ResultBean> getGuessHistory() {
		return guessHistory;
	}

	public void setGuessHistory(List<ResultBean> guessHistory) {
		this.guessHistory = guessHistory;
	}

}
