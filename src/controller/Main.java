package controller;

import javax.swing.*;

public class Main {

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            MainController mainController = new MainController();
            mainController.showMainForm();
        });
    }
}
