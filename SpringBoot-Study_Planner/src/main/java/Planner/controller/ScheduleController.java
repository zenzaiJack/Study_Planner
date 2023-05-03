package Planner.controller;

import java.time.LocalDateTime;
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
import Planner.repository.MemberMapper;
import Planner.repository.ScheduleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@Controller
public class ScheduleController {

	
	private final ScheduleMapper scheduleMapper;
	@GetMapping("month")		
	public String monthForm(Model model) {
		model.addAttribute("month", new Schedule());	
		return "schedule/month";
	}
	
	
	@GetMapping("week")		
	public String weekForm(Model model) {
		model.addAttribute("week", new Schedule());	
		return "schedule/week";
	}
	
	@PostMapping("week")
	public String week(@SessionAttribute(value = "loginMember", required = false) Member loginMember,
            @Validated @ModelAttribute("weekForm")ScheduleWriteForm scheduleWriteForm,
            BindingResult result) {
		 // 로그인 상태가 아니면 로그인 페이지로 보낸다.
        if (loginMember == null) {
            return "redirect:/member/login";
        }

        log.info("weekForm: {}", scheduleWriteForm);
        // validation 에러가 있으면 board/write.html 페이지를 다시 보여준다.
        if (result.hasErrors()) {
            return "schedule/week";
        }
        //날짜+시간 합치기
        LocalDateTime start_datetime = LocalDateTime.of(scheduleWriteForm.getStart_date().toLocalDate(), scheduleWriteForm.getStart_time().toLocalTime());
        LocalDateTime end_datetime = LocalDateTime.of(scheduleWriteForm.getEnd_date().toLocalDate(), scheduleWriteForm.getEnd_time().toLocalTime());
        scheduleWriteForm.setStart_date(start_datetime);
        scheduleWriteForm.setEnd_date(end_datetime);
        Schedule schedule = ScheduleWriteForm.toSchedule(scheduleWriteForm);
        schedule.setMember_id(loginMember.getMember_id());
        scheduleMapper.saveSchedule(schedule);
		return "schedule/week";
	}

	
}
