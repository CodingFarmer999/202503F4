package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.model.ResultBean;
import com.course.service.GuessService;

@Controller
public class GuessController {
	
	@Autowired
	private GuessService guessService;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/newGame")
	public String newGame() {
		System.out.println("newGame");
		guessService.getAnswer();
		return "index";
	}
	
	@GetMapping("/guess")
	public String guessAnswer(@RequestParam("guessNum") String guessNumber, Model model) {
		System.out.println("guess: "+guessNumber);
		guessService.checkAnswer(guessNumber);
		List<ResultBean> historyList = guessService.getHistory();
		model.addAttribute("history", historyList);
		return "index";
	}
	
	@GetMapping("/testSession")
	public String testSession() {
		guessService.testSession();
		return "index";
	}
}
