package com.course.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
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
