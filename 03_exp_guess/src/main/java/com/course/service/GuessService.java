package com.course.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.model.GameInfo;
import com.course.model.ResultBean;

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
	

	/**
	 * 檢查答案
	 * @param answer
	 * @param guessNum
	 * @return
	 */
	public ResultBean checkAnswer(String answer, String guessNum) {
		ResultBean result = new ResultBean();
		
		List<String> answerList = parseToList(answer);
		List<String> guessList = parseToList(guessNum);
		
		Integer aCount = 0;
		Integer bCount = 0;
		
		for (Integer index = 0; index < guessList.size() ; index += 1) {
			String num = guessList.get(index);
			// 數字是否有在答案之中
			Integer hitIndex = answerList.indexOf(num);
			if (hitIndex == index) {
				// 1A
				aCount += 1;
			} else if (hitIndex >= 0) {
				// 1B
				bCount += 1;
			}
		}
		
		result.setGuessNum(guessNum);
		result.setaCount(aCount);
		result.setbCount(bCount);
		result.setResultDisplay(aCount + "A" + bCount + "B");
		return result;
	}
	
	/**
	 * 將數字字串的每個數字轉換成字串陣列
	 * "1234" -> {"1", "2", "3", "4"}
	 * @param num
	 * @return
	 */
	private List<String> parseToList(String num) {
		List<String> list = new ArrayList<>();
		for(char c : num.toCharArray()) {
			list.add(String.valueOf(c));
		}
		return list;
	}
}
