package Planner.Model.schedule;

import java.time.LocalDate;


import lombok.Data;

@Data
public class TodaySchedule {
	private long subject_num;
	private String member_id;
	private String subject;
	private LocalDate today;
	private String start_time;
	private String end_time;
}