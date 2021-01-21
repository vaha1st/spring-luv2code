package com.vaha1st.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FreakingCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice burpies 20 reps";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
