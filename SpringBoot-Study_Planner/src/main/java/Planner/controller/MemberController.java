package Planner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	@GetMapping("login")
	public String login(Model model) {
		return "login";
	}
	
	@GetMapping("forget-password")
	public String forgotPassword(Model model) {
		return "forgot-password";
	}
	
	@GetMapping("register")
	public String register(Model model) {
		return "register";
	}
}
