package main.java.model;

public enum Urls {
	BEER_URL("beers"),
	STYLES_URL("styles");
	
	private String value;

	private Urls(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
