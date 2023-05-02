package Planner.controller;

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
	public String month(Model model) {
		model.addAttribute("month", new ScheduleWriteForm());	
		return "schedule/month";
	}
	
	
	@PostMapping("month")
    public String join(@SessionAttribute(value = "loginMember", required = false) Member loginMember,
    					@Validated @ModelAttribute("schedule") Schedule schedule,
                       BindingResult result) {
        log.info("schedule: {}", schedule);

        // validation 에 에러가 있으면 가입시키지 않고 member/joinForm.html 페이지로 돌아간다.
        if (result.hasErrors()) {
            return "schedule/month";
        }
        // 사용자로부터 입력받은 아이디로 데이터베이스에서 Member 를 검색한다.
//        Member member = memberMapper.findMember(joinForm.getMember_id());
        // 메인 페이지로 리다이렉트한다.
        return "schedule/month";
    }
	@GetMapping("week")		
	public String week(Model model) {
		model.addAttribute("month", new ScheduleWriteForm());	
		return "schedule/week";
	}
	
	
}
