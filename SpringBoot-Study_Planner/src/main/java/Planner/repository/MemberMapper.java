package Planner.repository;

import org.apache.ibatis.annotations.Mapper;

import Planner.Model.member.Member;

@Mapper
public interface MemberMapper {
	public Member findMember(String member_id);
}
