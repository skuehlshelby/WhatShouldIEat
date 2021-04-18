package controller;

import view.IMainPanel;
import view.MainPanel;
import view.RootFrame;

import java.awt.*;

public class MainController {
    private final IMainPanel mainPanel = new MainPanel();
    private final RootFrame rootFrame = new RootFrame("What Should I Eat?");

    public MainController() {
        rootFrame.getContentPane().add((Component) mainPanel);
    }

    public void showMainForm() {
        rootFrame.setVisible(true);
    }
}
