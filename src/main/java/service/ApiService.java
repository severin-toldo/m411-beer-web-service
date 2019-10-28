package main.java.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import main.java.model.Constants;

public class ApiService {
	public String sendGetRequest(String path, Map<String, String> queryParams) {
		WebResource resource = Client.create().resource(Constants.API_BASE_URL);
				

		ClientResponse response = resource
				.path(path)
				.queryParam("key", Constants.API_KEY)
				.queryParams(queryParams)
				.get(ClientResponse.class);
	    		
		
	
//			System.err.println("ERROR: Error while get request on url " + finalUrl + ": " + mfue.getMessage());
		
//		System.out.println("INFO: Get request on url " + finalUrl + " answered with " + responseCode);
		
		return response;
	}
	
	private void mapToJerseyMap(Map<String, String> map) {
		MultivaluedMap<String, String> mulitValueMap = 
		
		
	}
	
	private String getResponseAsJson(InputStream inputStream) throws IOException {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			String inputLine;
			
			while ((inputLine = br.readLine()) != null) {
				sb.append(inputLine);
			}
			
			br.close();	
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return sb.toString();
	}
}
