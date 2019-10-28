package main.java.gui;

import main.java.service.BeerService;
import main.java.model.Beer;
import main.java.service.BeerService;
import sun.management.MethodInfo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class BeerAdmin {
	private BeerService beerService = new BeerService();


      
    // severins test method
    public void test() {
    	beerService.getBeerById("abc");
        beerService.getBeers();
        beerService.getBeersByStyleId(1);
        beerService.getBeerStyles();
        beerService.getBeerStyles("Ale");
    }

    // severins main method
    // public static void main(String[] args){
        // BeerAdmin ba = new BeerAdmin();
        // ba.test();
    // }


    public static void main(String[] args) {
        System.out.println("Ausgabe aus der main()-Methode");
        BeerAdmin admin = new BeerAdmin();
        admin.printBeerStyles();
    }

    //	@Consumes HashMap<Integer, String>
    //	@Produces Syso
    //	printBeerStyles(): Erzeugt Konsolenausgabe der Bierarten. Die ″id″ soll jeweils mit ″::″
    //	getrennt vor Namen der Bierart ausgegeben werden.
    public void printBeerStyles() {
        //TODO:
        HashMap<Integer, String> beerStyles = new HashMap<>();
        beerStyles.forEach((x, y) -> System.out.println(x + "::" + y));
    }
    
    //
    //	@Consumes HashMap<Integer, String>
    //	@Produces Syso
    //	printBeerStyles(String search): Erzeugt Konsolenausgabe der Bierarten,
    //	welche die Zeichenfolge ″search″ im Namen enthalten. Die ″id″ soll jeweils mit ″::″ getrennt vor Namen der
    //	Bierart ausgegeben werden.
    //
    public void printBeerStyles(String search) {
        //TODO:
        HashMap<Integer, String> beerStyles = new HashMap<>();
        beerStyles.entrySet().stream().filter(x -> x.getValue().contains(search)).forEach(x -> System.out.println(x.getKey() + "::" + x.getValue()));
    }

    //	@Consumes List<Beer>
    //	@Produces Syso
    //	printBeerList(): gibt zeilenweise ID und Name der Biere im lokalen Speicher aus.
    public void printBeerList() {
        //TODO:
        ArrayList<Beer> beers = new ArrayList<>();
        beers.forEach(x -> System.out.println(x.getId() + "::" + x.getName()));
    }

    //	@Consumes HashMap<Integer, String>
    //	@Produces Syso
    //	printBeer(String id): gibt in einer Zeile ID und Namen und in einer zweiten
    //		Zeile die Beschreibung (″description″) des entsprechenden Bieres aus dem lokalen Speicher aus.
    public void printBeer(String id) {
        //TODO:
        ArrayList<Beer> beers = new ArrayList<>();
        Beer beer = beers.stream().filter(x -> x.getId() == id).findFirst().get();
        System.out.println(beer.getId() + "::" + beer.getName());
        System.out.println(beer.getDescription());
    }
}
