package main.java.user_interface.gui;

import main.java.model.Beer;
import main.java.service.BeerService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class BeerForm {
    public JPanel mainPanel;
    private JList<String> list1;
    private JButton mainButton;
    private JRadioButton radioButtonAllStyles;
    private JRadioButton radioButtonStyle;
    private JRadioButton radioButtonAllBeers;
    private JRadioButton radioButtonBeerWithId;
    private JTextField textFieldArgs;


    private BeerService beerService = new BeerService();

    public BeerForm(){
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonAllStyles);
        buttonGroup.add(radioButtonStyle);
        buttonGroup.add(radioButtonAllBeers);
        buttonGroup.add(radioButtonBeerWithId);

        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractButton selectedButton = null;
                for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                        selectedButton = button;
                    }
                }

                DefaultListModel<String> list = ((DefaultListModel<String>)list1.getModel());
                list.clear();
                if(selectedButton == radioButtonAllStyles){
                    beerService.getBeerStyles()
                            .forEach((k, v) -> list.addElement(k + "::" + v));
                }else if(selectedButton == radioButtonStyle){
                    beerService.getBeerStylesBySearchStr(textFieldArgs.getText())
                            .forEach((k, v) -> list.addElement(k + "::" + v));
                }else if(selectedButton == radioButtonAllBeers){
                    beerService.getBeers()
                            .forEach(x -> list.addElement((x.getId() + "::" + x.getName())));
                }else if(selectedButton == radioButtonBeerWithId){

                    System.out.println(textFieldArgs.getText());

                    Beer beer = beerService.getBeerById(textFieldArgs.getText());
                    // System.out.println(beer.toString());

                    if (beer != null) {
                        list.addElement(beer.getId() + "::" + beer.getName());
                    }
                }
            }
        });
    }
}
