package main.java.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.model.Beer;
import main.java.model.Constants;

public class BeerService {
	private ApiService apiService = new ApiService();
	
//	@Produces HashMap<Integer, String>
//	loadBeerStyles(): Die Bierarten können über die URL ″http://api.brewerydb.com/v2/styles/?″ +apiKey 
//	abgerufen werden. Speichern Sie für jede Bierart das Attribut ″id″ als Schlüssel, das Attribut ″name″ 
//	als Wert in einer Klassenvariable vom Typ HashMap.
	
//	@Consumes HashMap<Integer, String>
//	@Produces List<Beer>
//	getBeerListForStyle(int idStyle):  Über den folgenden Link liefert BreweryDB einen 
//	JSON Array der Biere mit der StyleId 5 (Extra Special Bitter):
//	http://api.brewerydb.com/v2/beers/?key=1511d0db4a1d6841481c672455358cff&styleId=5
//
//	Die JSON Serverantwort enthält unter dem Namen ″data″ eine Liste der Biere für 
//		diese Bierart. Parsen Sie von allen Bieren die ″id″, ″name″ und ″description″ 
//		Werte und speichern Sie diese in einer weiteren HashMap Ihrer ″BeerAdmin″ Klasse.
	
	public List<Beer> getBeers() {
		return null;
	}
	
	public List<Beer> getBeer(String id) {
		return null;
	}
	
	public List<Beer> getBeers(Integer styleId) {
		return null;
	}
	
	public List<Beer> getBeers(String id, Integer styleId) {
		return null;
	}
	
	public Map<Integer, String> getBeerStyles() {
		return null;
	}
	
	public Map<Integer, String> getBeerStyles(String searchString) {
		return null;
	}
	
	
	
//	@Consumes HashMap<Integer, String>
//	@Produces Syso
//	printBeerStyles(): Erzeugt Konsolenausgabe der Bierarten. Die ″id″ soll jeweils mit ″::″ 
//	getrennt vor Namen der Bierart ausgegeben werden.
//		  
//	@Consumes HashMap<Integer, String>
//	@Produces Syso
//	printBeerStyles(String search): Erzeugt Konsolenausgabe der Bierarten, 
//	welche die Zeichenfolge ″search″ im Namen enthalten. Die ″id″ soll jeweils mit ″::″ getrennt vor Namen der 
//	Bierart ausgegeben werden.
//
	
//	@Consumes List<Beer>
//	@Produces Syso
//	printBeerList(): gibt zeilenweise ID und Name der Biere im lokalen Speicher aus.

//	@Consumes HashMap<Integer, String>
//	@Produces Syso
//	printBeer(String id): gibt in einer Zeile ID und Namen und in einer zweiten 
//		Zeile die Beschreibung (″description″) des entsprechenden Bieres aus dem lokalen Speicher aus.
	
	
	
	
	
	
	

}
