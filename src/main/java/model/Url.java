package main.java.model;

public enum Url {
	BEER_URL("beers"),
	STYLES_URL("styles");
	
	private String value;

	private Url(String value) {
		this.value = Constants.API_BASE_URL + value;
	}

	public String getValue() {
		return value;
	}
}
