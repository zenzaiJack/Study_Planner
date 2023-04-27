package Planner.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import Planner.Model.Timer;

@Repository
@Mapper
public interface TimerMapper {
	public List<Timer> personStudy(String member_id);

}
