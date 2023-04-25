package Planner.Model.member;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.AllArgsConstructor;

import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class JoinForm {
	private String member_type;
	@Size(min = 4, max = 12)		// id는 4 ~ 12를 만족해야 함
	private String member_id;
	@Size(min = 6, max = 20)		// pw는 6 ~ 20를 만족해야 함
	private String password;
	@NotBlank
	private String nickname;
	@NotNull
	private String email;
	@Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate create_time;
	
	public static Member toMember(JoinForm joinForm) {
		Member member = new Member();
		member.setMember_id(joinForm.getMember_id());
		member.setPassword(joinForm.getPassword());
		member.setNickname(joinForm.getNickname());
		member.setEmail(joinForm.getEmail());
		member.setCreate_time(joinForm.getCreate_time());
		return member;
	}
}
