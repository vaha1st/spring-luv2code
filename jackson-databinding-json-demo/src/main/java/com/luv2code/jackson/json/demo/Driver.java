package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {
			
			// Create object mapper
			
			ObjectMapper mapper = new ObjectMapper();
			
			// Read JSON file and map/convert to POJO: 
			// data/sample-lite.json
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// Print name
			System.out.println("Student name: "+theStudent.getFirstName()+" "+theStudent.getLastName());
			System.out.println("Adress: "+theStudent.getAddress());
			System.out.println("Languages: "+theStudent.getLanguages().toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
