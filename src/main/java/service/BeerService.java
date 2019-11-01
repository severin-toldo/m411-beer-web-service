package main.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import main.java.model.Beer;
import main.java.model.Constants;
import main.java.model.Urls;

public class BeerService {
	/**
	 * @return Liste aller Biere der API zurück
	 * */
	public List<Beer> getBeers() {
		return getBeers(null, null);
	}
	
	/**
	 * @param id Id des gewünschten Bieres (z.B. c4f2KE)
	 * @return Bier mit bestimmter id, kann null sein
	 * */
	public Beer getBeerById(String id) {
		List<Beer> beers = getBeers(id, null);
		
		if (beers.size() > 1) {
			return null;
		} else {
			return beers.get(0);
		}
	}
	
	/**
	 * @param styleId Bierart id
	 * @return Liste aller Biere mit bestimmter styleId (z.B. 5)
	 * 
	 * */
	public List<Beer> getBeersByStyleId(Integer styleId) {
		return getBeers(null, styleId);
	}
	
	/**
	 * @param searchString String nachdem die Bierarten durchsucht werden sollen (z.B. "Ale")
	 * @return Map der Gefunden Bierarten, Id = key, name = value
	 * */
	public Map<Integer, String> getBeerStylesBySearchStr(String searchString) {
		return getBeerStyles()
				.entrySet()
				.stream()
				.filter(x -> x.getValue().contains(searchString))
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
	}
	
	/**
	 * @return Liste aller Bierarten (Styles) als map. Id = key, name = value
	 * */
	public Map<Integer, String> getBeerStyles() {
		String jsonResponse = sendGetRequest(Urls.STYLES_URL.getValue(), null);
		return jsonToStylesMap(jsonResponse);
	}
	
	/**
	 * @param id Bier id, kann null sein
	 * @param styleId Bierart id, kann null sein
	 * @return Lister aller gefunden Biere. Diese kann je nach mitgegeben parametern varieren.
	 * */
	private List<Beer> getBeers(String id, Integer styleId) {
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		
		if (id != null) {
			queryParams.add("id", id);
		}
		
		if (styleId != null) {
			queryParams.add("styleId", styleId.toString());
		}
		
		String jsonResponse = sendGetRequest(Urls.BEER_URL.getValue(), queryParams);
		return jsonToBeerList(jsonResponse);
	}
	
	/**
	 * Konvertiert den json String zu einer Liste von Bier Objekten.
	 * @param Bier json
	 * @return Konvertierte Liste
	 * */
	private List<Beer> jsonToBeerList(String jsonString) {
		List<Beer> beers = new ArrayList<>();
		
		JSONObject root = new JSONObject(jsonString);
		JSONArray data = root.getJSONArray("data");
		
		for (int i = 0; i < data.length(); i++) {
			JSONObject jsonObject = data.getJSONObject(i);
			Beer beer = new Beer();
			beer.setId(jsonObject.has("id") ? jsonObject.getString("id") : "");
			beer.setName(jsonObject.has("name") ? jsonObject.getString("name") : "");
			beer.setDescription(jsonObject.has("desctription") ? jsonObject.getString("description") : "");
			beer.setStyleId(jsonObject.has("styleId") ? jsonObject.getInt("styleId") : null);
			beers.add(beer);
		}
		
		return beers;
	}
	
	/**
	 * Konvertier den json String zu einer Bierarten map. Key = id, value = name
	 * @param Bierarten json
	 * @return Konvertierte Map
	 * */
	private Map<Integer, String> jsonToStylesMap(String jsonString) {
		Map<Integer, String> styles = new HashMap<>();
		
		JSONObject root = new JSONObject(jsonString);
		JSONArray data = root.getJSONArray("data");
		
		for (int i = 0; i < data.length(); i++) {
			JSONObject jsonObject = data.getJSONObject(i);
			styles.put(jsonObject.getInt("id"), jsonObject.getString("name"));
		}
		
		return styles;
	}
	
	// TODO implement callback
	/**
	 * @param path API Pfad (z.B. /beers)
	 * @param queryParams Optionale query params für den Aufruf (z.B. styleId=5), können null sein
	 * @return json string der API response
	 * @throws IllegalStateException falls die API etwas anderes als 200 Status code zurück gibt.
	 * */
	private synchronized String sendGetRequest(String path, MultivaluedMap<String, String> queryParams) {
		WebResource resource = Client.create().resource(Constants.API_BASE_URL);
		ClientResponse response = resource
				.path(path)
				.queryParam("key", Constants.API_KEY)
				.queryParams(queryParams!= null ? queryParams : new MultivaluedMapImpl())
				.get(ClientResponse.class);
		
		if (response != null && response.getStatus() == 200) {
			return response.getEntity(String.class);
		} else {
			throw new IllegalStateException("Error during api request! "  + response.getStatus());
		}
	}
}
