package com.vaha1st.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	Random random = new Random();
	String[] fortunes = {"Good luck", "Medium luck", "Bad luck"};
	
	@Override
	public String getFortune() {
		return fortunes[random.nextInt(fortunes.length)];
	}

}
