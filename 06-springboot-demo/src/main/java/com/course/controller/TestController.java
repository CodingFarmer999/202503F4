package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.course.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
}
