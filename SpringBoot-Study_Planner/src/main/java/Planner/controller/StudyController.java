package Planner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Planner.Model.Timer;
import Planner.repository.TimerMapper;

@RestController
public class StudyController {
	
	 @Autowired
	    private TimerMapper timerMapper;

	    @GetMapping("/study-time-list")
	    public List<Timer> getStudyTimeList(@RequestParam("member_id") String memberId) {
	        List<Timer> list = timerMapper.personStudy(memberId);
	        return list.subList(Math.max(list.size() - 7, 0), list.size());
	    }
}

