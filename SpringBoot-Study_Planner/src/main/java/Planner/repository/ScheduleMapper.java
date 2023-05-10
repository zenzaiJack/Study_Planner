package Planner.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;



import Planner.Model.schedule.*;

@Mapper
public interface ScheduleMapper {
	public void saveSchedule(Schedule schedule);
	public Schedule findSchedule(String member_id);
	List<Schedule> findfindSchedules(Schedule schedule);
	public void test1(Schedule Schedule);
	public void test2(TodaySchedule test1);
}
