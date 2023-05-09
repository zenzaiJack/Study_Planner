package Planner.Model.schedule;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;



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
	
	public static Schedule toSchedule(ScheduleWriteForm scheduleWriteForm) {
		Schedule schedule = new Schedule();
		schedule.setTitle(scheduleWriteForm.getTitle());
		schedule.setSubject(scheduleWriteForm.getSubject());
		schedule.setStart_date(scheduleWriteForm.getStart_date());
		schedule.setEnd_date(scheduleWriteForm.getEnd_date());
		return schedule;
	}
}
