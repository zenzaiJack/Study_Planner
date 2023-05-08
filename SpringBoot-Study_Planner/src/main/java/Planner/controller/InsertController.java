package Planner.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import Planner.Model.member.Member;
import Planner.Model.schedule.Schedule;
import Planner.Model.schedule.ScheduleWriteForm;
import Planner.repository.ScheduleMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class InsertController {
	
	private  ScheduleMapper scheduleMapper;
	@PostMapping("sendSchedule")
	public ResponseEntity<String> sendSchedule(@ModelAttribute ScheduleWriteForm scheduleWriteForm,
												@SessionAttribute("loginMember") Member loginMember){
		 LocalDateTime start_datetime = LocalDateTime.of(scheduleWriteForm.getStart_date().toLocalDate(), scheduleWriteForm.getStart_time().toLocalTime());
	     LocalDateTime end_datetime = LocalDateTime.of(scheduleWriteForm.getEnd_date().toLocalDate(), scheduleWriteForm.getEnd_time().toLocalTime());
	     scheduleWriteForm.setStart_date(start_datetime);
	     scheduleWriteForm.setEnd_date(end_datetime);
		Schedule schedule = ScheduleWriteForm.toSchedule(scheduleWriteForm);
		schedule.setMember_id(loginMember.getMember_id());
		log.info("schedule: {}", schedule);
        scheduleMapper.saveSchedule(schedule);
		return ResponseEntity.ok("ok");
	}
}
