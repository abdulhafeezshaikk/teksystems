package com.teksystems.test;

public class UserInputDeterminer {
	
	public boolean isUserInputCountryCode(String input) {
		boolean flag = false;
		if(input.trim().toCharArray().length <= 3) {
			flag = true;
		}
		return flag;
	}
}
