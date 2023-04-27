package Planner.Model.schedule;





import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ScheduleWriteForm {
	private String title;
	private LocalDateTime start_date;
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
