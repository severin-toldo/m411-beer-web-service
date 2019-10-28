package main.java.gui;

import main.java.service.BeerService;

public class BeerAdmin {
	private BeerService beerService = new BeerService();

    public static void main(String[] args){
    	BeerAdmin ba = new BeerAdmin();
    	ba.test();
    }
    
    public void test() {
    	beerService.getBeerById("abc");
//    	beerService.getBeers();
//    	beerService.getBeersByStyleId(1);
//    	beerService.getBeerStyles();
//    	beerService.getBeerStyles("Ale");
    }

    //	@Consumes HashMap<Integer, String>
//	@Produces Syso
//	printBeerStyles(): Erzeugt Konsolenausgabe der Bierarten. Die ″id″ soll jeweils mit ″::″ 
//	getrennt vor Namen der Bierart ausgegeben werden.
    public void prinBeerStyles(){

    }
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
    public void printBeerList(){

    }

//	@Consumes HashMap<Integer, String>
//	@Produces Syso
//	printBeer(String id): gibt in einer Zeile ID und Namen und in einer zweiten 
//		Zeile die Beschreibung (″description″) des entsprechenden Bieres aus dem lokalen Speicher aus.
    public void printBeer(String id){

    }

}
