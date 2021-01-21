package com.vaha1st.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("fortuneFromFile")
	private FortuneService fortuneService;
	
	/*
	 * @Autowired public TennisCoach(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */
	
	public TennisCoach() {
		System.out.println("TennisCoach: in deafult constructor");
	}
	
	/*
	 * @Autowired public void doSomeCrazyStuff(FortuneService fortuneService) {
	 * System.out.println("TennisCoach: in doSomeCrazyStuff"); this.fortuneService =
	 * fortuneService; }
	 */

	
	// define init and destroy methods
	
	@PostConstruct
	private void doMyInit() {
		System.out.println("Doing init stuff");
	}
	
	@PreDestroy
	private void doMyDestroy() {
		System.out.println("Doing destroy stuff");
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
