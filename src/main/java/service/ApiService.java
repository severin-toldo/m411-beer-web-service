package main.java.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import main.java.model.Constants;

public class ApiService {
	public String getBeerSytles() {
		return sendGetRequest(Constants.BEER_STYLE_URL);
	}
	
	private String sendGetRequest(String urlString) {
		HttpURLConnection con = null;
		String response = null;
		String responseCode = null;
		String finalUrl = null;
		
		try {
			finalUrl = Constants.API_BASE_URL + urlString + "?key=" + URLEncoder.encode(Constants.API_KEY, "UTF-8");
			con = (HttpURLConnection) new URL(finalUrl).openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("key", Constants.API_KEY);
			response = getResponseAsJson(con.getInputStream());
			responseCode = "" + con.getResponseCode();
		} catch (MalformedURLException mfue) {
			System.err.println("ERROR: Error while get request on url " + finalUrl + ": " + mfue.getMessage());
		} catch (IOException ioe) {
			System.err.println("ERROR: Error while get request on url " + finalUrl + ": " + ioe.getMessage());
		}
		
		System.out.println("INFO: Get request on url " + finalUrl + " answered with " + responseCode);
		
		return response;
	}
	
	private String getResponseAsJson(InputStream inputStream) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
		String inputLine;
		StringBuilder response = new StringBuilder();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		return response.toString();
	}
	
		
		
		//
//		printBeerStyles(): Erzeugt Konsolenausgabe der Bierarten. Die ″id″ soll jeweils mit ″::″ getrennt vor Namen der Bierart ausgegeben werden.
//		  
//		printBeerStyles(String search): Erzeugt Konsolenausgabe der Bierarten, welche die Zeichenfolge ″search″ im Namen enthalten. Die ″id″ soll jeweils mit ″::″ getrennt vor Namen der Bierart ausgegeben werden.
//
//		getBeerListForStyle(int idStyle):  Über den folgenden Link liefert BreweryDB einen JSON Array der Biere mit der StyleId 5 (Extra Special Bitter):
//		http://api.brewerydb.com/v2/beers/?key=1511d0db4a1d6841481c672455358cff&styleId=5
//
//		Die JSON Serverantwort enthält unter dem Namen ″data″ eine Liste der Biere für diese Bierart. Parsen Sie von allen Bieren die ″id″, ″name″ und ″description″ Werte und speichern Sie diese in einer weiteren HashMap Ihrer ″BeerAdmin″ Klasse.
//
//
//		printBeerList(): gibt zeilenweise ID und Name der Biere im lokalen Speicher aus.
//
//		printBeer(String id): gibt in einer Zeile ID und Namen und in einer zweiten Zeile die Beschreibung (″description″) des entsprechenden Bieres aus dem lokalen Speicher aus.


}
