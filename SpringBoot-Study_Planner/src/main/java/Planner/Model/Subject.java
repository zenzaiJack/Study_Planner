package Planner.Model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Subject {
	private String subject_name;
	private String proposal_time;
	private LocalDateTime start_period;
	private LocalDateTime end_period;
	private String member_id;

}
