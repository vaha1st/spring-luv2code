package com.vaha1st.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "I am very sad today";
	}

}
