package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Component
@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(String username, String password) {
		
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		return "loginSuccess";
	}
}
