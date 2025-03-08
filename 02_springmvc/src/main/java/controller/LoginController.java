package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Component
@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(@RequestParam("username2") String username, @RequestParam("password2") String password) {
		
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		return "loginSuccess";
	}
}
