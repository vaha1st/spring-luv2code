package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@GetMapping("/")
	public String sayHello() {
		
		return "HelloWorld! Current time on server - "+LocalDateTime.now();
	}
	
	// expose a new endpoint for "workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		
		return "Run a hard 5k!";
	}
	
	// expose a new endpoint for "fortune"
		@GetMapping("/fortune")
		public String getDailyFortune() {
			
			return "Today is your lucky day!";
		}

}
