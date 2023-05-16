package Planner.Model.schedule;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodayScheduleForm {
	private String member_id;
	@NotBlank
	private String subject;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate today;
	private String start_time;
	private String end_time;
}

