package Planner.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Planner.Model.member.Member;
import Planner.Model.timer.Timer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PluginController {
	
	// sessionStorage에 loginMember값 추가
	@GetMapping("setLoginMember")
	public Map<String, Object> setLoginMember(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginMember");
		session.setAttribute("member_id", "Test");
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", member);
		log.info("member : {}",member);
		return resultMap;
	}
	
	// sessionStorage에 loginMember값 삭제
	@GetMapping("deleteLoginMember")
	public String deleteLoginMember() {
		return null;
	}
	
	// 타이머 table에 값 추가
	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	@ResponseBody
	public void test2(HttpServletRequest request, String time){
		HttpSession session = request.getSession();
		Member loginMember = (Member) session.getAttribute("loginMember");
		
		Timer timer = new Timer();
		timer.setMember_id(loginMember.getMember_id());
		
	}
}
