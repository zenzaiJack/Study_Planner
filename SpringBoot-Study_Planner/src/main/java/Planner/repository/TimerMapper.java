package Planner.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import Planner.Model.Subject;
import Planner.Model.member.Member;
import Planner.Model.schedule.Schedule;
import Planner.Model.timer.Timer;
import Planner.Model.timer.TimerForm;


@Repository
@Mapper
public interface TimerMapper {
	// chart
	public void timer(Timer timer);
	public List<Timer> personStudy(String member_id);
	public List<Timer> selectTimersByMemberId(@Param("member_id") String memberId);
	public List<Timer> selectSubjectByMemberId(@Param("member_id") String memberId);
	// timer
	public void saveTimer(TimerForm timerForm);
	public List<String> getSubjectList(String member_id);
	

}
