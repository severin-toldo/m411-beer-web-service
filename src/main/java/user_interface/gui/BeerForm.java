package main.java.user_interface.gui;

import main.java.model.Beer;
import main.java.service.BeerService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

/**
 * BeerForm enthält ein Gui zum darstellen von Api-Antworten
 */
public class BeerForm {
    public JPanel mainPanel;
    private JList<String> listResults;
    private JButton mainButton;
    private JRadioButton radioButtonAllStyles;
    private JRadioButton radioButtonStyle;
    private JRadioButton radioButtonAllBeers;
    private JRadioButton radioButtonBeerWithId;
    private JTextField textFieldArgs;


    private BeerService beerService = new BeerService();

    /**
     *Konstruktor der Klasse BeerForm
     */
    public BeerForm(){
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonAllStyles);
        buttonGroup.add(radioButtonStyle);
        buttonGroup.add(radioButtonAllBeers);
        buttonGroup.add(radioButtonBeerWithId);

        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Selektieren Button ausfindig machen
                AbstractButton selectedButton = null;
                for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                        selectedButton = button;
                    }
                }

                //Model um das hinzufügen von Zeilen zu ermöglichen
                DefaultListModel<String> list = ((DefaultListModel<String>) listResults.getModel());
                //Jedes mal zuerst die Liste Leeren
                list.clear();
                if(selectedButton == radioButtonAllStyles){
                    /*
                     * Erzeugt Guiausgabe der Bierarten.
                     * Die id wird mit "::" vor dem Bierart Namen ausgeben.
                     * */
                    beerService.getBeerStyles()
                            .forEach((k, v) -> list.addElement(k + "::" + v));
                }else if(selectedButton == radioButtonStyle){
                    /*
                     *  Erzeugt Guiausgabe der Bierarten, welche die Zeichenfolge ″search″ im Namen enthalten.
                     *  Die id wird mit "::" vor dem Bierart Namen ausgeben.
                     *
                     *  @param searchString Zeichenfolge die enthalten sein soll
                     * */
                    beerService.getBeerStylesBySearchStr(textFieldArgs.getText())
                            .forEach((k, v) -> list.addElement(k + "::" + v));
                }else if(selectedButton == radioButtonAllBeers){
                    /*
                     * Gibt zeilenweise ID und Name mit "::" getrennt der Biere aus.
                     * */
                    beerService.getBeers()
                            .forEach(x -> list.addElement((x.getId() + "::" + x.getName())));
                }else if(selectedButton == radioButtonBeerWithId){
                    /*
                     * Gibt in einer Zeile ID und Namen und in einer zweiten Zeile die Beschreibung
                     * des entsprechenden Bieres aus.
                     *
                     * @param id id nach der gesucht werden soll
                     * */
                    Beer beer = beerService.getBeerById(textFieldArgs.getText());
                    if (beer != null) {
                        list.addElement(beer.getId() + "::" + beer.getName());
                    }
                }
            }
        });
    }
}
