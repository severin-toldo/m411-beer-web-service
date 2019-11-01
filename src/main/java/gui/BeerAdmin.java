package main.java.gui;

import main.java.service.BeerService;
import main.java.model.Beer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class BeerAdmin {
	private BeerService beerService = new BeerService();

    public static void main(String[] args) {
        BeerForm form = new BeerForm();
        JFrame frame = new JFrame();
        frame.setContentPane(form.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
