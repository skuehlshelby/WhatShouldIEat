package controller;

import model.IO;
import model.Restaurant;
import model.UserPrefs;
import view.FirstTimeStartup;
import view.RootFrame;

import java.util.ArrayList;
import java.util.List;

public class StartupController
{
    private final List<StartupCompleteListener> listeners = new ArrayList<>();
    private final RootFrame rootFrame;

    public StartupController(RootFrame rootFrame)
    {
        this.rootFrame = rootFrame;
    }

    public void doStartup()
    {
        IO io = new IO();
        UserPrefs prefs = io.getUserPreferences();
        List<Restaurant> data = io.loadFromFile(prefs.getStorageLocation());

        if(data.isEmpty())
        {
            showFirstTimeScreen(data);
        }
        else
        {
            startupComplete(data);
        }
    }

    private void showFirstTimeScreen(List<Restaurant> data)
    {
        FirstTimeStartup firstTimeStartup = new FirstTimeStartup();

        firstTimeStartup.registerStartClickListener(e -> startupComplete(data));
        //firstTimeStartup.registerLoadClickListener(); TODO
        rootFrame.setContent(firstTimeStartup.getContent());
    }

    public void onStartupCompletion(StartupCompleteListener listener)
    {
        listeners.add(listener);
    }

    private void startupComplete(List<Restaurant> data)
    {
        listeners.forEach(listener -> listener.startupComplete(data, rootFrame));
    }
}
