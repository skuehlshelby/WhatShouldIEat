package model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class IO
{
    public List<Restaurant> loadFromFile(String filePath)
    {
        /* TODO! */
        return new ArrayList<>();
    }

    public void writeToFile(String filePath, List<Restaurant> restaurants)
    {
        throw new NotImplementedException();
    }

    public UserPrefs getUserPreferences()
    {
        /* TODO! */
        return new UserPrefs();
    }
}
