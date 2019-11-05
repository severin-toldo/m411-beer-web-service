package main.java.user_interface.cli;

import main.java.service.BeerService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.java.model.Beer;

public class BeerAdminCli {
    public static void main(String[] args) throws IOException {
    	boolean stop = false;
    	BeerService beerService = new BeerService();
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	
    	while (!stop) {
    		System.out.println();
    		System.out.println();
    		System.out.println();
    		System.out.println("Bitte Option auswählen");
        	System.out.println("1: Alle Styles ausgeben");
        	System.out.println("2: Styles durchsuchen");
        	System.out.println("3: Alle Biere ausgeben");
        	System.out.println("4: Beer mit bestimmter id ausgeben");
        	System.out.println("0: Ende");
        	System.out.println();
        	System.out.println();
        	System.out.println();
        	
        	String decision = reader.readLine();
        	
    		switch (decision) {
    			case "1":
    				/*
    				 * Erzeugt Konsolenausgabe der Bierarten. 
    				 * Die id wird mit "::" vor dem Bierart Namen ausgeben.
    				 * */
    				beerService.getBeerStyles()
    	    			.forEach((k, v) -> System.out.println(k + "::" + v));
    				break;
    			
    			case "2":
    				System.out.println("Bitte Suchwort eingeben: ");
    				
    				/*
    				 *  Erzeugt Konsolenausgabe der Bierarten, welche die Zeichenfolge ″search″ im Namen enthalten. 
    				 *  Die id wird mit "::" vor dem Bierart Namen ausgeben.
    				 *  
    				 *  @param searchString Zeichenfolge die enthalten sein soll
    				 * */
    				beerService.getBeerStylesBySearchStr(reader.readLine())
    	    			.forEach((k, v) -> System.out.println(k + "::" + v));
    				break;
    				
    			case "3":
    				/*
    				 * Gibt zeilenweise ID und Name mit "::" getrennt der Biere aus.
    				 * */
    				beerService.getBeers()
    	        		.forEach(x -> System.out.println(x.getId() + "::" + x.getName()));
    				break;
    				
    			case "4":
    				/*
    			     * Gibt in einer Zeile ID und Namen und in einer zweiten Zeile die Beschreibung 
    			     * des entsprechenden Bieres aus.
    			     * 
    			     * @param id id nach der gesucht werden soll
    			     * */
    				System.out.println("Bitte id eingeben: ");
    		        String id = reader.readLine();
    				Beer beer = beerService.getBeerById(id);
    		        
    		        if (beer != null) {
    		        	System.out.println(beer.getId() + "::" + beer.getName());
    		            System.out.println(beer.getDescription());	
    		        } else {
    		        	System.out.println("Kein Bier mit id " + id + " gefunden.");
    		        }
    				break;
    			
    			case "0":
    				System.out.println("Ok, good bye");
    		        stop = true;
    				break;

    			default:
    				System.out.println("Keine Gültige eingabe!");	
    				break;
    		}	
    	}
    }
}
