package Planner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	@GetMapping("login")	// 로그인
	public String login(Model model) {
		return "login";
	}
	
	@GetMapping("forget-password")	// 비밀번호 찾기
	public String forgotPassword(Model model) {
		return "forgot-password";
	}
	
	@GetMapping("register")		// 회원가입
	public String register(Model model) {
		return "register";
	}
}
