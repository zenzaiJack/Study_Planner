package Planner.repository;

import org.apache.ibatis.annotations.Mapper;

import Planner.Model.member.Member;
import Planner.Model.schedule.Schedule;

@Mapper
public interface MemberMapper {
	public void saveMember(Member member);
	public Member findMember(String member_id);
	public void saveSchedule(Schedule schdule);
}