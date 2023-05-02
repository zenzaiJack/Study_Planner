package Planner.Model.schedule;

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
	private LocalDateTime start_date;
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime end_date;
	 @DateTimeFormat(pattern = "aa hh:mm")
	private LocalDateTime start_time;
	 @DateTimeFormat(pattern = "aa hh:mm")
	private LocalDateTime end_time;
	
	public static Schedule toSchedule(ScheduleWriteForm scheduleWriteForm) {
		Schedule schedule = new Schedule();
		schedule.setTitle(scheduleWriteForm.getTitle());
		schedule.setSubject(scheduleWriteForm.getSubject());
		schedule.setStart_date(scheduleWriteForm.getStart_date());
		schedule.setEnd_date(scheduleWriteForm.end_date);
		schedule.setStart_time(scheduleWriteForm.start_time);
		return schedule;
	}
}
