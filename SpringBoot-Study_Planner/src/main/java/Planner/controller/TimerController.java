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
import org.springframework.web.bind.annotation.RequestParam;

import Planner.Model.member.LoginForm;
import Planner.Model.member.Member;
import Planner.Model.timer.Timer;
import Planner.Model.timer.TimerForm;
import Planner.repository.TimerMapper;

@Controller
public class TimerController {

	private TimerMapper timerMapper;
	
	@GetMapping("/timer")
	public String setTimer(Model model) {
		model.addAttribute("timerForm", new TimerForm());
		return "timer/Timer";
	}

	@PostMapping("/timer")
	public String saveTimer(@Validated @ModelAttribute("timerForm") TimerForm timerForm, Model model,
							HttpServletResponse response, HttpServletRequest request, BindingResult result,
							@RequestParam(defaultValue = "/") String redirectURL) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		timerForm.setMember_id(member.getMember_id());
		timerMapper.saveTimer(timerForm);
		return "timer";
	}
}
