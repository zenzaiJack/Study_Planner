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
	
	
	
//	// 게시글 쓰기
//    @PostMapping("write")
//    public String write(@SessionAttribute(value = "loginMember", required = false) Member loginMember,
//                        @Validated @ModelAttribute("writeForm") ScheduleWriteForm scheduleWriteForm,
//                        BindingResult result,
//                        @RequestParam(required = false) MultipartFile file) {
//        // 로그인 상태가 아니면 로그인 페이지로 보낸다.
//        if (loginMember == null) {
//            return "redirect:/member/login";
//        }
//
//        // validation 에러가 있으면 board/write.html 페이지를 다시 보여준다.
//        if (result.hasErrors()) {
//            return "redirect:/";
//        }
//
//        // 파라미터로 받은 BoardWriteForm 객체를 Board 타입으로 변환한다.
//        Schedule schedule = ScheduleWriteForm.toSchedule(scheduleWriteForm);
//        // board 객체에 로그인한 사용자의 아이디를 추가한다.
//        schedule.setMember_id(loginMember.getMember_id());
//        // board 객체를 저장한다.
//        scheduleMapper.saveSchedule(schedule);;
//
//        // board/list 로 리다이렉트한다.
//        return "redirect:/";
//    }
}
