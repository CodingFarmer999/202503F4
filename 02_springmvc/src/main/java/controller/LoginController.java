package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@Component
@Controller
public class LoginController {

//	@RequestMapping(value = "/login", method = {RequestMethod.GET})
	@GetMapping("/login")
	public String login(@RequestParam("username2") String username, @RequestParam("password2") String password) {
		
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		
		if (username.equals("HelloKitty")) {
			return "loginSuccess";
		} else {
			return "loginFail";
		}
		
	}
}
