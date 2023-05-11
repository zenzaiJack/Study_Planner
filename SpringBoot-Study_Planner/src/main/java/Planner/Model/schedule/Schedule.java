package Planner.Model.schedule;

import java.time.LocalDate;


import lombok.Data;

@Data
public class Schedule {
	private long schedule_num;
	private String member_id;
	private String title;
	private String subject;
	private LocalDate start_date;
	private LocalDate end_date;
}
