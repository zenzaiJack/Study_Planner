package Planner.Model.member;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.format.annotation.DateTimeFormat;



@Data
public class RegisterForm {
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
	
	public static Member toMember(RegisterForm registerForm) {
		Member member = new Member();
		member.setMember_id(registerForm.getMember_id());
		member.setPassword(registerForm.getPassword());
		member.setNickname(registerForm.getNickname());
		member.setEmail(registerForm.getEmail());
		return member;
	}
}
