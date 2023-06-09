package Planner.Model.member;

import java.util.Date;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Member {
	private long member_num;
	private String member_type;
	private String member_id;
	private String password;
	private String nickname;
	private String email;
	private LocalDate create_time;
	
}
