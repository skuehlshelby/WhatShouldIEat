package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Restaurants {
    private final List<Restaurant> restaurants = new ArrayList<>();
    private final Random random = new Random();

    public Restaurants() {

    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public Restaurant choose() {
        return restaurants.get(random.nextInt(restaurants.size()));
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }
}
