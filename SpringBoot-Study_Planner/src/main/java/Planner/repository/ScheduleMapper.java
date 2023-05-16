package Planner.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import Planner.Model.schedule.Schedule;
import Planner.Model.schedule.TodaySchedule;
import Planner.Model.schedule.TodayScheduleForm;
import Planner.Model.schedule.TodayScheduleResult;

@Mapper
public interface ScheduleMapper {
   public void saveSchedule(Schedule schdule);
   public Schedule findSchedule(String member_id);
   List<Schedule> findfindSchedules(Schedule schedule);
   
   public void saveToday(TodaySchedule todaySchedule);
   public Schedule findToday(String member_id);
   List<TodaySchedule> findfindToday(TodaySchedule todaySchedule);
   public List<String> findSubjectList(String member_id);
   public List<TodayScheduleResult> findTodayList(String member_id);
   
   public void updateToday(TodayScheduleForm todayScheduleForm);
   public List<TodayScheduleResult> findBySubject(String subject);
}
