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
            MainController mainController = new MainController();
            mainController.showMainForm();
        });
    }
}
