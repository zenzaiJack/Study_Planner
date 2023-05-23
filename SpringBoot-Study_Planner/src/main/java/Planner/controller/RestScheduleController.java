package Planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.time.LocalDate;
import java.util.*;

import Planner.Model.member.Member;
import Planner.Model.schedule.CalendarVO;
import Planner.Model.schedule.TodaySchedule;
import Planner.Model.schedule.TodayScheduleResult;
import Planner.repository.ScheduleMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestScheduleController {
	
	@Autowired
	private ScheduleMapper scheduleMapper;
	
	@PostMapping("/postSchedule")
	public String postScheduleEvent(@RequestBody CalendarVO calendarVO, @SessionAttribute("loginMember") Member loginMember) {
		calendarVO.setMember_id(loginMember.getMember_id());
		scheduleMapper.saveEvents(calendarVO);
		return "Post Schedule Events";
	}
	
	@GetMapping("/getSchedule")
	public List<CalendarVO> getScheduleList(@SessionAttribute("loginMember") Member loginMember){
		List<CalendarVO> allSchedule = scheduleMapper.selectAllSchedule(loginMember.getMember_id());
		return allSchedule;
	}
	
	@GetMapping("/today")
	public List<TodayScheduleResult> getTodaySchedule(@RequestParam("subject") String subject, @SessionAttribute("loginMember") Member loginMember) {
		String member_id = loginMember.getMember_id();
		List<TodayScheduleResult> subjectlist = scheduleMapper.findBySubject(subject);
		log.info("list : {}", subjectlist);
		return subjectlist;
	}

}
