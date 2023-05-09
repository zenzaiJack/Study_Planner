package Planner.Model.schedule;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;


import lombok.Data;

@Data
public class ScheduleWriteForm {
	@NotBlank
	private String title;
	@NotBlank
	private String subject;
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate start_date;
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate end_date;
//	 @DateTimeFormat(pattern = "a hh:mm")
	private String start_time;
//	 @DateTimeFormat(pattern = "a hh:mm")
	private String end_time;
	
	public static Schedule toSchedule(ScheduleWriteForm scheduleWriteForm) {
		Schedule schedule = new Schedule();
		schedule.setTitle(scheduleWriteForm.getTitle());
		schedule.setSubject(scheduleWriteForm.getSubject());
		schedule.setStart_date(scheduleWriteForm.getStart_date());
		schedule.setEnd_date(scheduleWriteForm.getEnd_date());
		schedule.setStart_time(scheduleWriteForm.getStart_time());
		schedule.setEnd_time(scheduleWriteForm.getEnd_time());
		return schedule;
	}
}
