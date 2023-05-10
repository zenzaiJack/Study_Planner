package Planner.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import Planner.Model.member.LoginForm;
import Planner.Model.member.Member;
import Planner.Model.member.RegisterForm;
import Planner.Model.schedule.Schedule;
import Planner.Model.schedule.ScheduleWriteForm;
import Planner.Model.schedule.TodaySchedule;
import Planner.repository.MemberMapper;
import Planner.repository.ScheduleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ScheduleController {


	//달별 확인
	private final ScheduleMapper scheduleMapper;

	@GetMapping("month")
	public String monthForm(Model model) {
		model.addAttribute("month", new Schedule());
		return "schedule/month";
	}

	
	//월별 입력
	@PostMapping("month")
	public String month(@SessionAttribute(value = "loginMember", required = false) Member loginMember,
            @Validated @ModelAttribute("monthForm")ScheduleWriteForm scheduleWriteForm,
            BindingResult result, HashMap<String, String> param) {
		log.info("param: {}", param);
        log.info("ScheduleWriteForm: {}", scheduleWriteForm);
        // validation 에러가 있으면 board/write.html 페이지를 다시 보여준다.
        if (result.hasErrors()) {
            return "schedule/month";
        }
        
        Schedule schedule = ScheduleWriteForm.toSchedule(scheduleWriteForm);
        schedule.setMember_id(loginMember.getMember_id());
        scheduleMapper.saveSchedule(schedule);
        log.info("Schedule: {}", schedule);
		return "schedule/week";
	}
	
			



	//주별 확인
	@GetMapping("week")
	public String weekForm(Model model) {
		model.addAttribute("week", new Schedule());
		return "schedule/week";
	}

	
	//주별 입력


//	@PostMapping("week")
//	public String week(@SessionAttribute(value = "loginMember", required = false) Member loginMember,
//            @Validated @ModelAttribute("weekForm")ScheduleWriteForm scheduleWriteForm,
//            BindingResult result) {
//		 // 로그인 상태가 아니면 로그인 페이지로 보낸다.
//        if (loginMember == null) {
//            return "redirect:/member/login";
//        }
//
//        log.info("weekForm: {}", scheduleWriteForm);
//        // validation 에러가 있으면 board/write.html 페이지를 다시 보여준다.
//        if (result.hasErrors()) {
//            return "schedule/week";
//        }
//        //날짜+시간 합치기
//        LocalDateTime start_datetime = LocalDateTime.of(scheduleWriteForm.getStart_date().toLocalDate(), scheduleWriteForm.getStart_time().toLocalTime());
//        LocalDateTime end_datetime = LocalDateTime.of(scheduleWriteForm.getEnd_date().toLocalDate(), scheduleWriteForm.getEnd_time().toLocalTime());
//        scheduleWriteForm.setStart_date(start_datetime);
//        scheduleWriteForm.setEnd_date(end_datetime);
//        Schedule schedule = ScheduleWriteForm.toSchedule(scheduleWriteForm);
//        schedule.setMember_id(loginMember.getMember_id());
//        scheduleMapper.saveSchedule(schedule);
//		return "schedule/week";
//	}

	@PostMapping("week")
   public String week(@SessionAttribute(value = "loginMember", required = false) Member loginMember,
            @Validated @ModelAttribute("weekForm")ScheduleWriteForm scheduleWriteForm,
            BindingResult result, HashMap<String, String> param) {
		log.info("param: {}", param);
       // 로그인 상태가 아니면 로그인 페이지로 보낸다.
//        if (loginMember == null) {
//            return "redirect:/member/login";
//        }
        log.info("ScheduleWriteForm: {}", scheduleWriteForm);
        // validation 에러가 있으면 board/write.html 페이지를 다시 보여준다.
        if (result.hasErrors()) {
            return "schedule/week";
        }
        
        Schedule schedule = ScheduleWriteForm.toSchedule(scheduleWriteForm);
        String member_id = loginMember.getMember_id();
        log.info("member_id : {}", member_id);
        schedule.setMember_id(loginMember.getMember_id());
        log.info("member_id : {}", member_id);
        log.info("loginMember.getMember_id : {}", loginMember.getMember_id());
        scheduleMapper.saveSchedule(schedule);
        log.info("Schedule: {}", schedule);
		return "schedule/week";
   }
	@PostMapping("test")
	   public String test(@SessionAttribute(value = "loginMember", required = false) Member loginMember,
	            @Validated @ModelAttribute("weekForm")ScheduleWriteForm scheduleWriteForm,
	            BindingResult result, HashMap<String, String> param) {
			log.info("param: {}", param);
	       // 로그인 상태가 아니면 로그인 페이지로 보낸다.
//	        if (loginMember == null) {
//	            return "redirect:/member/login";
//	        }
	        log.info("ScheduleWriteForm: {}", scheduleWriteForm);
	        // validation 에러가 있으면 board/write.html 페이지를 다시 보여준다.
	        if (result.hasErrors()) {
	            return "schedule/week";
	        }
	        
	        Schedule schedule = ScheduleWriteForm.toSchedule(scheduleWriteForm);
	        String member_id = loginMember.getMember_id();
	        log.info("member_id : {}", member_id);
	        schedule.setMember_id(loginMember.getMember_id());
	        log.info("member_id : {}", member_id);
	        log.info("loginMember.getMember_id : {}", loginMember.getMember_id());
	        scheduleMapper.test1(schedule);
	        for(int i = 0; i <= ChronoUnit.DAYS.between(schedule.getStart_date(), schedule.getEnd_date()); i++) {
	        	TodaySchedule todaySchedule = new TodaySchedule();
	        	todaySchedule.setMember_id(member_id);
	        	todaySchedule.setSubject(schedule.getSubject());
	        	todaySchedule.setToday(schedule.getStart_date().plusDays(i));
	        	scheduleMapper.test2(todaySchedule);
	        }
	        log.info("Schedule: {}", schedule);
			return "schedule/week";
	}
}