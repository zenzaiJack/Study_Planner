package Planner.Model.timer;

import lombok.Data;

@Data
public class TimerForm {
	private long timer_num;
	private String member_id;
	private String study_date;
	private long study_time;
	private String subject_name;
}
	