package Planner.Model.schedule;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Schedule {
	private String member_id;
	private String title;
	private String contents;
	private LocalDateTime start_date;
	private LocalDateTime end_date;

}
