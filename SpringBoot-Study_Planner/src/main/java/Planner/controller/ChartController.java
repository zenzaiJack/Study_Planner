package Planner.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
       Map<String, BigDecimal> studyTimeMap = new LinkedHashMap<>();

       List<Timer> timers = timerMapper.selectTimersByMemberId(loginMember.getMember_id());

       // DB에서 가져온 Timer 객체를 이용해 studyTimeMap에 데이터 추가
       for (Timer timer : timers) {
           String studyDate = timer.getStudy_date().substring(0, 10); // 날짜만 추출
           BigDecimal studyTime = studyTimeMap.getOrDefault(studyDate, BigDecimal.ZERO);
           int studyTimeSeconds = (int) timer.getStudy_time();
           int studyTimeMinutes = studyTimeSeconds / 60; // 초 -> 분
           double studyTimeHours = (double) studyTimeMinutes / 60; // 분 -> 시간
           BigDecimal studyTimeHoursDecimal = new BigDecimal(studyTimeHours).setScale(1, RoundingMode.HALF_UP); // 소수점 첫 번째 자리까지 반올림
           studyTime = studyTime.add(studyTimeHoursDecimal); // 기존 값과 합산
           studyTimeMap.put(studyDate, studyTime);
       }

       List<String> labels = new ArrayList<>();
       List<BigDecimal> values = new ArrayList<>();

       // DB에서 가져온 Timer 객체를 이용해 labels와 values 리스트에 데이터 추가
       for (int i = timers.size() - 1; i >= 0 && i >= timers.size() - 7; i--) {
           Timer timer = timers.get(i);
           labels.add(0, timer.getStudy_date().substring(0, 10)); // 역순으로 추가
           int studyTimeSeconds = (int) timer.getStudy_time();
           int studyTimeMinutes = studyTimeSeconds / 60; // 초 -> 분
           double studyTimeHours = (double) studyTimeMinutes / 60; // 분 -> 시간
           BigDecimal studyTimeHoursDecimal = new BigDecimal(studyTimeHours).setScale(1, RoundingMode.HALF_UP); // 소수점 첫 번째 자리까지 반올림
           values.add(0, studyTimeHoursDecimal); // 역순으로 추가
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
       List<Float> time = new ArrayList<>(); // 데이터 타입을 List<Float>로 변경

       List<Timer> pies = timerMapper.selectSubjectByMemberId(loginMember.getMember_id());

       for (Timer pie : pies) {
           subject.add(pie.getSubject_name()); // 과목 이름 받아오기
           int studyTimeInSeconds = (int) pie.getStudy_time_sum();
           float studyTimeInHours = (float) Math.round(studyTimeInSeconds / 360.0f) / 10.0f; // 소수점 첫 번째 자리까지 반올림하여 저장
           time.add(studyTimeInHours); // 소수점 첫 번째 자리까지 표현된 공부 시간 추가
       }

       data.put("subject", subject);
       data.put("time", time);
       return data;
   }
}
