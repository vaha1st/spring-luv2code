package com.vaha1st.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	private String email;
	private String team;
	
	public void setEmail(String email) {
		System.out.println("CricketCoach: inside setter method - setEmail");
		this.email = email;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method - setTeam");
		this.team = team;
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	// create no argument constructor
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-argument constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling";
	}


	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}
	
	// init and destroy methods
	private void doCricketInit() {
		System.out.println("Cricket init-method called");
	}
	private void doCricketDestroy() {
		System.out.println("Cricket destroy-method called");

	}

}
