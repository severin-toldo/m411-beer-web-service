package main.java.user_interface.gui;

import javax.swing.*;

public class BeerAdminGui {
    public static void main(String[] args) {
        BeerForm form = new BeerForm();
        JFrame frame = new JFrame();
        frame.setContentPane(form.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
