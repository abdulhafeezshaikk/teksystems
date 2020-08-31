package com.teksystems.test;

import java.util.regex.Pattern;

public class InputValidations {
	public boolean isValidInput(String input) {
		UserInputDeterminer determiner = new UserInputDeterminer();
		boolean isInputValid = true;

		if (determiner.isUserInputCountryCode(input)) {
			if (input.toCharArray().length < 3) {
				System.out.println("Test-1: country code cannot be less than 3 characters - Failed");
				isInputValid = false;
			} else {
				System.out.println("Test-1: length check - Passed");
			}

			if (input.matches(".*\\d.*")) {
				System.out.println("Test-2: country code cannot be numerics - Failed");
				isInputValid = false;
			} else {
				System.out.println("Test-2: no numbers - Passed");
			}

			if (input.contains(" ")) {
				System.out.println("Test-3: country code cannot contain white spaces - Failed");
				isInputValid = false;
			} else {
				System.out.println("Test-3: no whitespaces - Passed");
			}

			Pattern regex = Pattern.compile("[$&+,:;=\\\\?@#|/'<>.^*()%!-]");
			if (regex.matcher(input).find()) {
				System.out.println("Test-4: country code cannot have special characters - Failed");
				isInputValid = false;
			} else {
				System.out.println("Test-4: no special characters - Passed");
			}
			return isInputValid;
		} else {
			if (input.matches(".*\\d.*")) {
				System.out.println("Test-1: country name cannot have numbers - Failed");
				isInputValid = false;
			} else {
				System.out.println("Test-1: no numbers - Passed");
			}

			Pattern regex = Pattern.compile("[$&+,:;=\\\\?@#|/'<>.^*()%!_]");
			if (regex.matcher(input).find()) {
				System.out.println("Test-2: country name cannot have special characters - Failed");
				isInputValid = false;
			} else {
				System.out.println("Test-2: no special characters - Passed");
			}

			if (!input.matches("^[a-z A-Z]+(-[a-z A-Z]+)?$")) {
				System.out.println("Test-3: country name cannot start/end or have multiple hyphens(-) - Failed");
				isInputValid = false;
			} else {
				System.out.println("Test-3: no invalid hyphens - Passed");
			}
			return isInputValid;
		}
	}
}
