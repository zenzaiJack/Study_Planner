package Planner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

<<<<<<< HEAD
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	 
=======
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
>>>>>>> branch 'BackUp' of https://github.com/zenzaiJack/Study_Planner.git
}
