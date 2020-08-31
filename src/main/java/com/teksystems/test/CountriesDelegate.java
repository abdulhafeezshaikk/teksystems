package com.teksystems.test;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

public class CountriesDelegate {
	public List<CountryResponse> getCountryByCode(String countryCode) {
		String url = "https://restcountries.eu/rest/v2/alpha/"+countryCode;
		RestTemplate restTemplate = new RestTemplate();
		CountryResponse result = restTemplate.getForObject(url, CountryResponse.class);
		List<CountryResponse> res = Arrays.asList(result);
		return res;
	}
	
	public List<CountryResponse> getCountryByName(String countryName) {
		String url = "https://restcountries.eu/rest/v2/name/"+countryName;
		RestTemplate restTemplate = new RestTemplate();
		CountryResponse[] result = restTemplate.getForObject(url, CountryResponse[].class);
		List<CountryResponse> res = Arrays.asList(result);
		return res;
	}
}