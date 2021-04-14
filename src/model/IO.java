package model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IO
{
    public static List<Restaurant> loadFromFile()
    {
        UserPrefs prefs = new UserPrefs();

        if(prefs.getRestaurantDataLocation().isPresent())
        {
            try
            {
                XStream xStream = new XStream();

                Object restaurantData = xStream.fromXML(Paths.get(prefs.getRestaurantDataLocation().get()).toFile());

                if(restaurantData instanceof List<?>)
                {
                    List<?> asList = (List<?>)restaurantData;

                    if(asList.stream().allMatch(item -> item instanceof Restaurant))
                    {
                        return asList.stream().map(Restaurant.class::cast).collect(Collectors.toList());
                    }
                }

                return new ArrayList<>();
            }
            catch(XStreamException e)
            {
                System.out.printf("%s: %s\n", e.getClass().getSimpleName(), e.getMessage());
            }
        }

        return new ArrayList<>();
    }

    public static void writeToFile(String filePath, List<Restaurant> restaurants)
    {
        throw new NotImplementedException();
    }

    private static UserPrefs getUserPreferences()
    {
        UserPrefs prefs = new UserPrefs();
        prefs.load();
        return prefs;
    }
}
