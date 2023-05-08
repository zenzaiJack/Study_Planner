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
	 @DateTimeFormat(pattern = "a hh:mm")
	private LocalDateTime start_time;
	 @DateTimeFormat(pattern = "a hh:mm")
	private LocalDateTime end_time;
	
	public static Schedule toSchedule(ScheduleWriteForm scheduleWriteForm) {
		Schedule schedule = new Schedule();
		schedule.setTitle(scheduleWriteForm.getTitle());
		schedule.setSubject(scheduleWriteForm.getSubject());
		LocalDateTime start_datetime = LocalDateTime.of(scheduleWriteForm.getStart_date().toLocalDate(), scheduleWriteForm.getStart_time().toLocalTime());
        LocalDateTime end_datetime = LocalDateTime.of(scheduleWriteForm.getEnd_date().toLocalDate(), scheduleWriteForm.getEnd_time().toLocalTime());
		schedule.setStart_date(start_datetime);
		schedule.setEnd_date(end_datetime);
		return schedule;
	}
}
