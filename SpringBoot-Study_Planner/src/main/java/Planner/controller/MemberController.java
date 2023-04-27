package Planner.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import Planner.Model.member.LoginForm;
import Planner.Model.member.Member;
import Planner.Model.member.RegisterForm;
import Planner.repository.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MemberController {
	
	private final MemberMapper memberMapper;
	
	@GetMapping("/")	// 로그인
	public String login(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}
	
	@PostMapping("/")
	public String login(@Validated @ModelAttribute("loginForm") LoginForm loginForm, Model model,
						HttpServletResponse response, HttpServletRequest request, BindingResult result,
						@RequestParam(defaultValue = "/") String redirectURL) {
		if (result.hasErrors()) {
			return "redirect:/";
		}
		
		Member member = memberMapper.findMember(loginForm.getMember_id());
		// 아이디 or 비밀번호 틀렸을시 로그인폼으로 돌아감
		if (member == null || !member.getPassword().equals(loginForm.getPassword())) {
			result.reject("loginError", "아이디가 없거나 패스워드가 다릅니다.");
			return "redirect:/";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("loginMember", member);			
		return "working/index";
	}
	
	//일단 지금은 사용하지 않을 예정입니다.
	@GetMapping("forgot-password")	// 비밀번호 찾기
	public String forgotPassword(Model model) {
		return "working/forgot-password";
	}
	
	@GetMapping("register")		// 회원가입
	public String register(Model model) {
		model.addAttribute("registerForm", new RegisterForm());	
		return "working/register";
	}
	
	@PostMapping("register")
	public String register(@Validated @ModelAttribute("registerForm") RegisterForm registerForm,
						   BindingResult result) {
		if(memberMapper.findMember(registerForm.getMember_id()) != null) {
			result.reject("duplicate ID", "이미 가입된 아이디 입니다.");
			return "working/register";
			
		}
		log.info("register() 실행");
		memberMapper.saveMember(registerForm.toMember(registerForm));
		return "redirct:/";
	}
	
	@GetMapping("logout")  // 로그아웃
	public String register(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
}
