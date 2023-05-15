package Planner.Model.schedule;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TodayScheduleResult {
	private String member_id;
	private String subject;
	private LocalDate today;
}
