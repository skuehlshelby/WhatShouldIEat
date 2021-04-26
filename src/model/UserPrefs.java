package model;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Properties;

/**
 * @author Scott Kuehl-Shelby
 */
public class UserPrefs
{
    private static final String localStorage = "WhatShouldIEat.Properties";
    private static final String restaurantDataLocation = "Storage Location";
    private static final Properties properties = new Properties();

    public UserPrefs()
    {

    }

    public void load()
    {
        try(Reader reader = Files.newBufferedReader(Paths.get(localStorage)))
        {
            properties.load(reader);
        }
        catch (IOException e)
        {
            System.out.printf("%s: %s\n", e.getClass().getSimpleName(), e.getMessage());
        }
    }

    public String getDefaultRestaurantDataLocation()
    {
        return System.getProperty("user.home");
    }

    public Optional<String> getRestaurantDataLocation()
    {
        String location = properties.getProperty(restaurantDataLocation);

        return Optional.ofNullable(location);
    }

    public void setRestaurantDataLocation(String location)
    {
        properties.setProperty(restaurantDataLocation, location);
    }

    public void store()
    {
        try (Writer writer = Files.newBufferedWriter(Paths.get(localStorage)))
        {
            properties.store(writer, "Application Properties");
        }
        catch (IOException e)
        {
            System.out.printf("%s: %s\n", e.getClass().getSimpleName(), e.getMessage());
        }
    }
}
