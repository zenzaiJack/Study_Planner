package Planner.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import Planner.Model.member.Member;
import Planner.Model.timer.TimerChecker;
import Planner.Model.timer.TimerForm;
import Planner.repository.TimerMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RestTimerController {
	private final TimerMapper timerMapper;
	
	public RestTimerController(TimerMapper timerMapper) {
		this.timerMapper = timerMapper;
	}

	@PostMapping("sendTimer")
	public String sendTimer(@RequestBody TimerChecker timerChecker, @SessionAttribute("loginMember") Member loginMember){
		System.out.println("Vo : " + timerChecker.toString());
		TimerForm timerForm = new TimerForm();
		timerForm.setMember_id(loginMember.getMember_id());
		timerForm.setStudy_time(timerChecker.getStudy_time());
		log.info("timerForm : {}", timerForm);
		timerMapper.saveTimer(timerForm);
		return "Post Mapping Data";
	}
}
