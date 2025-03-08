package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.UserVo;

//@Component
@Controller
public class LoginController {

//	@RequestMapping(value = "/login", method = {RequestMethod.GET})
	@GetMapping("/login")
	public String login(@RequestParam("username2") String username, @RequestParam(value = "password2", required = false) String password) {

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
	
	@GetMapping("/login/user/{username}")
	public String testPath(@PathVariable("username") String username) {
		System.out.println("username :" + username);
		return "loginSuccess";
	}
	
	@PostMapping("/param/class")
	public String getHobby(UserVo user) {
		System.out.println(user);
		return "loginSuccess";
	}
	
	@RequestMapping(value = "/loginModel")
	public String loginModel(@RequestParam("username2") String username, @RequestParam(value = "password2") String password, Model model) {
	    model.addAttribute("user", "佛殺凱蒂貓二世");
	    return "loginSuccess";
	}
	
	@RequestMapping(value = "/loginModelAndView")
	public ModelAndView loginModelAndView(UserVo user) {
	    ModelAndView mv = new ModelAndView();
	    // 設置視圖名稱
	    mv.setViewName("loginSuccess");
	    // 添加模型資料
	    mv.addObject("user", user);
	    return mv;
	}
	
	// 應用在方法參數上
	@RequestMapping(value = "/loginModelAttribute")
	public String loginModel(@ModelAttribute("user3") UserVo user) {
	    return "loginFail";
	}
	
	// 應用在方法返回的物件上
	@ModelAttribute("title")
	public String getTitle() {
	    return "我是標題";
	}
}
