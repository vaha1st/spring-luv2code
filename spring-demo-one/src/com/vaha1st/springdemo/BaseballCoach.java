package com.vaha1st.springdemo;

public class BaseballCoach implements Coach {
	
	// define a private field for dependency
	private FortuneService fortuneService;
	
	public BaseballCoach() {
		super();
	}

	// define a constructor for dependency injection
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting";
	}

	@Override
	public String getDailyFortune() {
		
		// use my fortuneService for get a fortune
		return fortuneService.getFortune();
	}
	
}
