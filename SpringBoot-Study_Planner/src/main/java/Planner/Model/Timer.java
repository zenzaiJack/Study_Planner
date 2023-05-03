package Planner.Model;

import java.util.Date;
import lombok.Data;

@Data
public class Timer {
	private long timer_num;
	private String member_id;
	private String study_date;
	private long study_time;
	private String Subject_name;
	private long study_time_sum;

}
