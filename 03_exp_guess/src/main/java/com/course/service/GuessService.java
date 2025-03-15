package com.course.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.model.GameInfo;

@Service
public class GuessService {

	@Autowired
	private GameInfo gameInfo;
	
	public String getAnswer() {
		// {"8, "3", "5", "1"}
		List<Integer> answerList = new ArrayList<>();
		
		while(answerList.size() < 4) {
			// 隨機取得0~9的數字
			Integer num = ThreadLocalRandom.current().nextInt(0,  10);
			if (!answerList.contains(num)) {
				answerList.add(num);
			}
		}

		// Collection Framework
		// 8351
		String answerStr = answerList.stream().map(n -> String.valueOf(n)).collect(Collectors.joining());
		
		System.out.println("answer: " + answerStr);
		gameInfo.setAnswer(answerStr);
		return answerStr;
	}
	
	public void testSession() {
		String answer = gameInfo.getAnswer();
		System.out.println(answer);
	}
}
