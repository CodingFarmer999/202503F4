package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

	// "?" 匹配一個字元 test1, test2 -> OK, test10 -> NO
	// @RequestMapping("/pattern/test?")
	public String pattern1() {
		System.out.println("Pattern: /pattern/test?");
		return "loginSuccess";
	}

	// "*" 匹配多個字元 test10, test100 -> OK
	// @RequestMapping("/pattern/test*")
	public String pattern2() {
		System.out.println("Pattern: /pattern/test*");
		return "loginSuccess";
	}

	// "**" 匹配零個或多個路徑，路徑名稱任意 /abcd, /abcd/defg -> OK
	@RequestMapping("/pattern/**")
	public String pattern3() {
		System.out.println("Pattern: /pattern/**");
		return "loginSuccess";
	}

	@RequestMapping(value = "/loginRequest")
	public String loginRequest(HttpServletRequest req, HttpServletResponse res) {
		// 取得QueryString的參數值
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		req.setAttribute("user", "佛殺凱蒂貓");
		return "loginSuccess";
	}
}
