package Planner.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import Planner.Model.Subject;
import Planner.Model.member.Member;
import Planner.Model.timer.Timer;
import Planner.repository.TimerMapper;

@Controller
public class ChartController {
   
   @Autowired
    private TimerMapper timerMapper;
       
       @GetMapping("/chart-data")
       @ResponseBody
       public Map<String, Object> getChartData(@SessionAttribute(value = "loginMember", required = false) Member loginMember) {
           Map<String, Object> data = new HashMap<>();
           List<String> labels = new ArrayList<>();
           List<Integer> values = new ArrayList<>();
           List<Timer> timers = timerMapper.selectTimersByMemberId(loginMember.getMember_id());
           // DB에서 가져온 Timer 객체를 이용해 labels와 values 리스트에 데이터 추가
           for (int i = timers.size() - 1; i >= 0 && i >= timers.size() - 7; i--) {
               Timer timer = timers.get(i);
               labels.add(0, timer.getStudy_date().substring(0,11)); // 역순으로 추가
               values.add(0, (int) timer.getStudy_time()); // 역순으로 추가
           }
           data.put("labels", labels);
           data.put("data", values);
           return data;
       }
      
      @GetMapping("/pie-data")
       @ResponseBody
       public Map<String, Object> getPieData(@SessionAttribute(value = "loginMember", required = false) Member loginMember) {
           Map<String, Object> data = new HashMap<>();
           List<String> subject = new ArrayList<>();
           List<Integer> time = new ArrayList<>();
           List<Timer> pies = timerMapper.selectSubjectByMemberId(loginMember.getMember_id());

           for (Timer pie : pies) {
               subject.add(pie.getSubject_name()); // 과목 이름 받아오기
               time.add((int)pie.getStudy_time_sum()); // 공부 시간 받아오기
           }
           
           data.put("subject", subject);
           data.put("time", time);
           return data;
       }
}
