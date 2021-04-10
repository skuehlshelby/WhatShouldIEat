package controller;

import model.Restaurant;
import view.RootFrame;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        RootFrame rootFrame = new RootFrame();
	    StartupController startup = new StartupController(rootFrame);

	    startup.onStartupCompletion(Main::onStartupComplete);
        startup.doStartup();
    }

    private static void onStartupComplete(List<Restaurant> data, RootFrame rootFrame)
    {
        MainController controller = new MainController();


    }
}
