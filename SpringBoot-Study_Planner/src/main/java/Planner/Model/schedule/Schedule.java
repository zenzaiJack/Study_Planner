package Planner.Model.schedule;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Schedule {
	private String member_id;
	private String title;
	private LocalDateTime start_date;
	private LocalDateTime end_date;
	private LocalDateTime start_time;
	private LocalDateTime end_time;

}
