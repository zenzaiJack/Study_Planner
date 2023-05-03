package Planner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TimerController {
	
	@GetMapping("/timer")
	public String setTimer() {
		
		return "timer";
	}
	
	@PostMapping("/timer")
	public String getTimer() {
		
		return "timer";
	}
}
