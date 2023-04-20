package Planner.Model;

import java.util.Date;

import lombok.Data;

@Data
public class Member {
	private String member_id;
	private String password;
	private String nickname;
	private String email;
	private Date create_time;
	
}
