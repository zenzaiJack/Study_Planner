package Planner.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Planner.Model.Timer;
import Planner.repository.TimerMapper;

@Controller
public class StudyController {
	
	@Autowired
    private TimerMapper timerMapper;
    
    @RequestMapping(value = "/studyTimeList/{member_id}", method = RequestMethod.GET)
    @ResponseBody
    public String studyTimeList(@PathVariable String member_id, HttpServletResponse response) {
        List<Timer> list = timerMapper.personStudy(member_id);
        List<String> array = new ArrayList<>();
        for(int i = list.size() - 1; i >= Math.max(0, list.size()-7); i--) {
            String study_date = list.get(i).getStudy_date();
            array.add(study_date);
        }
        JSONArray jsonArray = new JSONArray(array);
        String jsonStr = jsonArray.toString();
        response.setContentType("application/json");
        return jsonStr;
    }
}
	

