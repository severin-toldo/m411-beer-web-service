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
}
