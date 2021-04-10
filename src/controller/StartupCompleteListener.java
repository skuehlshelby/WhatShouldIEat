package controller;

import model.Restaurant;
import view.RootFrame;

import java.util.List;

@FunctionalInterface
public interface StartupCompleteListener
{
    void startupComplete(List<Restaurant> initialData, RootFrame rootFrame);
}
