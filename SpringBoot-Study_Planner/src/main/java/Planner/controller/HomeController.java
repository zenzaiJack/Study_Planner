package Planner.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import Planner.Model.member.Member;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	 


	
//	@GetMapping("/")
//	public String index(@SessionAttribute(name = "loginMember", required = false) Member loginMember
//						) {
//		return "/";
//	}
}

