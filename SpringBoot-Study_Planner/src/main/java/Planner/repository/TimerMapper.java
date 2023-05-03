package Planner.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import Planner.Model.Timer;
import Planner.Model.member.Member;

@Repository
@Mapper
public interface TimerMapper {
	public void timer(Timer timer);
	public List<Timer> personStudy(String member_id);
	public List<Timer> selectTimersByMemberId(@Param("member_id") String memberId);

}
