package controller;

import model.Restaurant;
import view.MainPanel;
import view.RestaurantCard;
import view.RootFrame;

import javax.swing.*;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            RootFrame rootFrame = new RootFrame("What should I eat?");
            MainPanel mainPanel = new MainPanel();

            mainPanel.getButtonPanel().addChooseClickListener(e -> JOptionPane.showMessageDialog(rootFrame, "'Choose!' was clicked!"));
            mainPanel.getButtonPanel().addSelectAllClickListener(e -> JOptionPane.showMessageDialog(rootFrame, "'Select All' was clicked!"));
            mainPanel.getButtonPanel().addSelectNoneClickListener(e -> JOptionPane.showMessageDialog(rootFrame, "'Select None' was clicked!"));
            mainPanel.getButtonPanel().addAddAnotherClickListener(e -> JOptionPane.showMessageDialog(rootFrame, "'Add Another' was clicked!"));

            //mainPanel.getDataPanel().getFreshStartPanel().addLoadFromFileClickListener(e -> JOptionPane.showMessageDialog(rootFrame, "'Load From File' was clicked!"));
            mainPanel.getDataPanel().getFreshStartPanel().addLoadFromFileClickListener(e -> mainPanel.getDataPanel().showCardDisplayPanel());
            mainPanel.getDataPanel().getFreshStartPanel().addAddNewClickListener(e -> JOptionPane.showMessageDialog(rootFrame, "'Add New' was clicked!"));

            mainPanel.getDataPanel().getCardDisplayPanel().addCard(new RestaurantCard("WestSide Coffee", "Asiago Bagel", "Coffee"));
            mainPanel.getDataPanel().getCardDisplayPanel().addCard(new RestaurantCard("Herms Inn", "Greek Skillet", "Cinnamon Swirl Pancake"));
            mainPanel.getDataPanel().getCardDisplayPanel().addCard(new RestaurantCard("WestSide Coffee", "Asiago Bagel", "Coffee"));
            mainPanel.getDataPanel().getCardDisplayPanel().addCard(new RestaurantCard("Herms Inn", "Greek Skillet", "Cinnamon Swirl Pancake"));

            rootFrame.getContentPane().add(mainPanel);
            rootFrame.pack();
            rootFrame.setVisible(true);
        });

    }
}
