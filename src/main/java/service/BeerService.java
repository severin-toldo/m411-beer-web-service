package main.java.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.model.Beer;
import main.java.model.Urls;

public class BeerService {
	private ApiService apiService = new ApiService();

	
	// printBeerList()
	public List<Beer> getBeers() {
		return getBeers(null, null);
	}
	
	// printBeer()
	public Beer getBeerById(String id) {
		return getBeers(id, null).get(0);
	}
	
	// getBeerListForStyle()
	public List<Beer> getBeersByStyleId(Integer styleId) {
		return getBeers(null, styleId);
	}
	
	// printBeerStyles
	public Map<Integer, String> getBeerStyles(String searchString) {
		// TODO filter
		return getBeerStyles();
	}
	
	// printBeerStyles
	public Map<Integer, String> getBeerStyles() {
		String jsonResponse = apiService.sendGetRequest(Urls.STYLES_URL.getValue(), null);
		return jsonToStylesMap(jsonResponse);
	}
	
	private List<Beer> getBeers(String id, Integer styleId) {
		Map<String, Object> queryParams = new HashMap<>();
		
		if (id != null) {
			queryParams.put("id", id);	
		}
		
		if (styleId != null) {
			queryParams.put("styleId", styleId);
		}
		
		String jsonResponse = apiService.sendGetRequest(Urls.BEER_URL.getValue(), queryParams);
		return jsonToBeerList(jsonResponse);
	}
	
	private List<Beer> jsonToBeerList(String jsonString) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode root = objectMapper.readTree(jsonString);
			String dataJson = objectMapper.writeValueAsString(root.get("data"));
			return objectMapper.readValue(dataJson, new TypeReference<List<Beer>>(){});
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	private Map<Integer, String> jsonToStylesMap(String jsonString) {
		Map<Integer, String> styles = new HashMap<>();
		
		JSONObject root = new JSONObject(jsonString);
		// JSONArray jsonArray = (JSONArray) new JSONTokener(jsonString).nextValue();
		JSONArray data = root.getJSONArray("data");
		
		for (int i = 0; i < data.length(); i++) {
			JSONObject jsonObject = data.getJSONObject(i);
			styles.put(jsonObject.getInt("id"), jsonObject.getString("name"));
		}
		
		return styles;
	}
}
