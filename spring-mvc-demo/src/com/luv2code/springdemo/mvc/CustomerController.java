package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// add an initbinder ... to convert input strings
	// remove leadings and trailing whitespace
	// resolve issue to our validation
	@InitBinder
	private void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
	
		dataBinder.registerCustomEditor(String.class, stringTrimmer);
		
		}

	@RequestMapping("/showForm")
	private String showForm(Model model) {
		
		model.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	private String processForm(
			@Valid @ModelAttribute("customer") Customer cutomer, BindingResult bindingResult) {
		
		System.out.println("Last Name : | "+cutomer.getLastName()+" |");
		
		System.out.println("Binding Result: "+bindingResult);
		
		System.out.println("\n\n\n\n");
		
		if(bindingResult.hasErrors()) {
			return "customer-form";
		} else
		return "customer-confirmation";
	}
	
}
