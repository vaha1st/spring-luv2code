package com.vaha1st.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FortuneFromFile implements FortuneService {

	Random random = new Random();
	List<String> fortunes = new ArrayList<String>();

	@PostConstruct
	private void readFromFile() {
		File file = new java.io.File("/Users/ruslan/eclipse-workspace/spring-demo-annotations/src/fortunes.properties");

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String tempLine;

			while ((tempLine = reader.readLine()) != null) {
				fortunes.add(tempLine);
			}
			
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public String getFortune() {
		return fortunes.get(random.nextInt(fortunes.size()));
	}

}
