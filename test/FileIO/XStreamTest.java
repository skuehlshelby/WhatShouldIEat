package FileIO;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import model.Address;
import model.Cuisine;
import model.IO;
import model.Restaurant;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class XStreamTest {
    @Test
    void writeTest(){
        Address address = new Address();
        address.setZip(84321);
        address.setState("UT");
        address.setCity("Logan");
        address.setStreet("100 W");

        Restaurant restaurant = new Restaurant();
        restaurant.setAddress(address);
        restaurant.setName("Westside Coffee");
        restaurant.setCuisine(Cuisine.Other);

        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(restaurant);

        IO.writeToFile("C:\\Users\\georg\\Documents\\CS1410\\WhatShouldIEat\\test\\FileIO\\serializedRestaurant.xml", restaurants);
    }

    @Test
    void readTest(){
        Optional<List<Restaurant>> restaurants = IO.loadFromFile("C:\\Users\\georg\\Documents\\CS1410\\WhatShouldIEat\\test\\FileIO\\serializedRestaurant.xml");
    }
}
