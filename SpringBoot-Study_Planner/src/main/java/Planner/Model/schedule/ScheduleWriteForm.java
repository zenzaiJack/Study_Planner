package Planner.Model.schedule;





import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ScheduleWriteForm {
	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime start_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime end_date;
	private LocalDateTime start_time;
	private LocalDateTime end_time;
	
	public static Schedule toSchedule(ScheduleWriteForm scheduleWriteForm) {
		Schedule schedule = new Schedule();
		schedule.setTitle(scheduleWriteForm.getTitle());
		schedule.setStart_date(scheduleWriteForm.getStart_date());
		schedule.setEnd_date(scheduleWriteForm.getEnd_date());
		schedule.setStart_time(scheduleWriteForm.getStart_time());
		schedule.setEnd_time(scheduleWriteForm.getEnd_time());
		return schedule;
	}
}
