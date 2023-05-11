package Planner.Model.schedule;



import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TodaySchedule {
	private String member_id;
	@NotBlank
	private String subject;
	@NotBlank
	private String start_time;
	@NotBlank
	private String end_time;
}

