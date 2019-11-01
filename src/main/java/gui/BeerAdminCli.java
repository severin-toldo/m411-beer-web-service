package main.java.gui;

import main.java.service.BeerService;
import main.java.model.Beer;

public class BeerAdminCli {
	private BeerService beerService = new BeerService();

	
    public static void main(String[] args) {
        BeerAdminCli admin = new BeerAdminCli();
        
        int decision = 0;
        
        do {
        	System.err.println("Bitte Option auswählen");
        	System.err.println("1: Alle Styles ausgeben");
        	System.err.println("2: Styles durchsuchen");
        	System.err.println("3: Alle Biere ausgeben");
        	System.err.println("4: Beer mit bestimmter id ausgeben");
        	System.err.println("0: Ende");
        	
        	Scanner sc = new Scanner();
        	
        	if ()
        	
        	
        	
        } while (decision != 0);
        
       
        
        
        
        
        
        
        
//        
        System.err.println("printBeerStyles");
        admin.printBeerStyles();
        
        System.err.println("printBeerStyles");
        admin.printBeerStyles("Ale");
        
        System.err.println("printBeerList");
        admin.printBeerList();
        
        System.err.println("printBeer");
        admin.printBeer("c4f2KE");
    }

    public void printBeerStyles() {
    	beerService.getBeerStyles()
    		.forEach((k, v) -> System.out.println(k + "::" + v));
    }
    
    public void printBeerStyles(String searchString) {
    	beerService.getBeerStylesBySearchStr(searchString)
    		.forEach((k, v) -> System.out.println(k + "::" + v));
    }

    public void printBeerList() {
        beerService.getBeers()
        	.forEach(x -> System.out.println(x.getId() + "::" + x.getName()));
    }

    public void printBeer(String id) {
        Beer beer = beerService.getBeerById(id);
        System.out.println(beer.getId() + "::" + beer.getName());
        System.out.println(beer.getDescription());
    }
}
