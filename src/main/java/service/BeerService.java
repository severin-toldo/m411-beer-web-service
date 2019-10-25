package main.java.service;

import java.util.Map;

import main.java.model.Constants;

public class BeerService {
	private ApiService apiService = new ApiService();
	
	public static void main(String[] args) {
		BeerService bs = new BeerService();	
		bs.getBeerSytles();
	}
	
	
	
	public Map<Integer, String> getBeerSytles() {
		// TODO get values from response and fill it to hashmap
		System.out.println(apiService.getBeerSytles());
		return null;
	}
	
	
//		Speichern Sie für jede Bierart das Attribut ″id″ 
//		als Schlüssel, das Attribut ″name″ als Wert in einer Klassenvariable vom Typ HashMap.
}
