package main.java.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import main.java.model.Constants;

public class ApiService {
	private String sendGetRequest(String urlString, Map<String, Object> queryParams) {
		HttpURLConnection con = null;
		String response = null;
		String responseCode = null;
		String finalUrl = urlString; // null
		
		try {
//			finalUrl = Constants.API_BASE_URL + urlString + "?key=" + URLEncoder.encode(Constants.API_KEY, "UTF-8");
			con = (HttpURLConnection) new URL(urlString).openConnection();
			con.setRequestMethod("GET");
			addQueryParams(con, queryParams);
			
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
	
	private void addQueryParams(HttpURLConnection con, Map<String, Object> queryParams) {
		con.setRequestProperty("key", Constants.API_KEY);
		
		if (queryParams != null) {
			for (String key : queryParams.keySet()) {
				con.setRequestProperty(key, queryParams.get(key).toString());
			}	
		}
	}
}
