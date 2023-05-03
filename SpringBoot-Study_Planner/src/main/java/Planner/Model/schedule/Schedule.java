package Planner.Model.schedule;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Schedule {
	private long schedule_num;
	private String member_id;
	private String title;
	private String subject;
	private LocalDateTime start_date;
	private LocalDateTime end_date;

}
