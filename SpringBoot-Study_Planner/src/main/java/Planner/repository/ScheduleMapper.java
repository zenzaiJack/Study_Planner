package Planner.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;



import Planner.Model.schedule.Schedule;
import Planner.Model.schedule.TodaySchedule;

@Mapper
public interface ScheduleMapper {
	public void saveSchedule(Schedule schdule);
	public Schedule findSchedule(String member_id);
	List<Schedule> findfindSchedules(Schedule schedule);
	
	public void saveToday(TodaySchedule todaySchedule);
	public Schedule findToday(String member_id);
	List<TodaySchedule> findfindToday(TodaySchedule todaySchedule);
	public List<String> findSubjectList(String member_id);;
}

