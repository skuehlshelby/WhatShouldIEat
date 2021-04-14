package controller;

import model.Restaurant;
import view.MainPanel;
import view.RootFrame;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        RootFrame rootFrame = new RootFrame();
        rootFrame.setContent(new MainPanel());
        rootFrame.show();
    }

    private static void onStartupComplete(List<Restaurant> data, RootFrame rootFrame)
    {
        MainController controller = new MainController();


    }
}
