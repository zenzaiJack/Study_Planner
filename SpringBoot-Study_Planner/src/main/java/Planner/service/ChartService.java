package Planner.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Planner.Model.timer.Timer;
import Planner.repository.TimerMapper;

public class ChartService {
	private TimerMapper timerMapper;
	
	// DB에서 개인 스터디 시간 가져오는 메소드
	public void studyTimeList(String member_id) {
		List<Timer> list = timerMapper.personStudy(member_id);	// DB에서 가져온거
		List<String> array = new ArrayList<>();		// 자바스크립트로 넘기는 거
		for(int i = list.size(); i > list.size()-7; i--) {
			String study_date = list.get(i).getStudy_date();
			array.add(study_date);
		}
	}
	
	// DB에서 개인 공부과목 들고오는 메소드
	public List<String> getSubjectList(String member_id) {
		List<String> list = timerMapper.getSubjectList(member_id);
		return list;
	}
}
