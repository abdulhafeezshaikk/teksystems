package com.teksystems.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.web.client.HttpClientErrorException;

public class TeksystemsTest {
	
	public static List<CountryResponse> response;

	public static void main(String[] args) {
		boolean run = true;
	    Scanner scanner = new Scanner(System.in);
	    String userInput = "";

	    while (run) {
	    	System.out.println("enter country name or 3 digit country code: ");
	        userInput = scanner.nextLine();
	        System.out.println("user input is: "+userInput);
	        
	        InputValidations validations = new InputValidations();
	        UserInputDeterminer determiner = new UserInputDeterminer();
	        
	        if(validations.isValidInput(userInput)) {
	        	CountriesDelegate delegate = new CountriesDelegate();
	        	try {
	        		if (determiner.isUserInputCountryCode(userInput)) {
		        		response = delegate.getCountryByCode(userInput);
		        	} else {
		        		response = delegate.getCountryByName(userInput);
		        	}
	        	} catch(HttpClientErrorException ex){
	        		System.out.println("Data Not Found");
	        		response = null;
	        	}
	        	
	        	if(response != null)
	        	response.forEach( (x) -> {
	        		System.out.println("Name: "+x.getName());
			        System.out.println("Native Name: "+x.getNativeName());
			        System.out.println("Capital: "+x.getCapital());
			        System.out.println("Population: "+x.getPopulation());
	        	} );
	        }
	        
	        System.out.println("Continue? [Y/N]");
	        userInput = scanner.nextLine();
	        
	        while (!userInput.matches("[YyNn]")){
	            System.out.println("please enter [Y/N] only");
	            userInput = scanner.nextLine();
	        }

	        if(userInput.matches("[Nn]")){
	            System.out.println("Do you wish to exit the program? [Y]");
	            String choice = scanner.nextLine();

	            if (choice.toLowerCase().equals("y"))
	                run = false;
	        }
	    }
	    scanner.close();
	}}
