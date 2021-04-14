package controller;

import model.IO;
import model.Restaurant;
import model.UserPrefs;
import view.RootFrame;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;
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
        List<Restaurant> data = IO.loadFromFile();

        if(data.isEmpty())
        {
//            showFirstTimeScreen();
        }
        else
        {
            startupComplete(data);
        }
    }


    private void onStartClick(ActionEvent e)
    {
        startupComplete(new ArrayList<>());
    }

    private void onLoadClick(ActionEvent e)
    {
        JFileChooser fileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("XML Files", ".xml");
        fileChooser.addChoosableFileFilter(filter);

/*        if (fileChooser.showOpenDialog(firstTimeStartup.getContent()) == JFileChooser.APPROVE_OPTION)
        {
            File file = fileChooser.getSelectedFile();
            new UserPrefs().setRestaurantDataLocation(file.getAbsolutePath());
            startupComplete(IO.loadFromFile());
        }*/
    }

    public void registerStartupCompleteListener(StartupCompleteListener listener)
    {
        listeners.add(listener);
    }

    private void startupComplete(List<Restaurant> data)
    {
        listeners.forEach(listener -> listener.startupComplete(data, rootFrame));
    }
}
