package Planner.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Planner.Model.Timer;
import Planner.repository.TimerMapper;

@Controller
public class StudyController {
	
//	 @Autowired
//	    private TimerMapper timerMapper;
//
//	    @GetMapping("test")
//	    public String getStudyTimeList() {
////	        List<Timer> list = timerMapper.personStudy(memberId);
//	        return "/working/test";
//	    }
	    
	    @GetMapping("/chart-data")
	    @ResponseBody
	    public Map<String, Object> getChartData() {
	        Map<String, Object> data = new HashMap<>();
	        List<String> labels = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
	        List<Integer> values = Arrays.asList(10, 5, 7, 3, 0, 7, 12);
	        data.put("labels", labels);
	        data.put("data", values);
	        return data;
	    }
}

