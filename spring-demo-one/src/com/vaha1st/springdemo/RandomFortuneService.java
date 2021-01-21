package com.vaha1st.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	private String[] fortuneArray = {"Good luck", "Medium luck", "Bad luck"};

	@Override
	public String getFortune() {
		Random rand = new Random();
		return fortuneArray[rand.nextInt(3)];
	}

}
