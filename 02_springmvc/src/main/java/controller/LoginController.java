package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Component
@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login() {
		return "loginSuccess";
	}
}
