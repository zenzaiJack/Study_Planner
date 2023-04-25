package Planner.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import Planner.Model.member.Member;

@Controller
public class MemberController {
	@GetMapping("login")	// 로그인
	public String login(Model model) {
//		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}
	
	@PostMapping("login")
//	public String login(@ModelAttribute("loginForm") LoginForm loginForm, BindingResult result) {
		
//	}
	
	//일단 지금은 사용하지 않을 예정입니다.
	@GetMapping("forget-password")	// 비밀번호 찾기
	public String forgotPassword(Model model) {
		return "forgot-password";
	}
	
	@GetMapping("register")		// 회원가입
	public String register(Model model) {
//		model.addAttribute("registerForm", new RegisterForm());
		return "register";
	}
	
//	@PostMapping("register")
//	public String register(@ModelAttribute("registerForm") RegisterForm registerForm,
//						   BindingResult result) {
//		
//	}
	
	@GetMapping("logout")
	public String register(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
}
