package Planner.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import Planner.Model.member.Member;
import Planner.Model.timer.Timer;
import Planner.Model.timer.TimerForm;
import Planner.repository.TimerMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	private TimerMapper timerMapper;
	
	@GetMapping("index")
	public String index(@SessionAttribute(name = "loginMember", required = false) Member loginMember, Model model) {
		List<String> subject = new ArrayList<>();
		List<String> subjects = timerMapper.getSubjectList(loginMember.getMember_id());
	    log.info("subjects : {}", subjects);
	    model.addAttribute("subjects", subjects);
	    TimerForm timerForm = new TimerForm();
	    timerForm.setMember_id(loginMember.getMember_id());
	    model.addAttribute("timerForm", timerForm);
	    return "working/index";
	    
	    
        
       
	}
}

