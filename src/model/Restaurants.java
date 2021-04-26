package model;

import javax.swing.event.EventListenerList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Scott Kuehl-Shelby
 */
public class Restaurants {
    private final EventListenerList events;
    private final List<Restaurant> restaurants = new ArrayList<>();
    private final Random random = new Random();

    public Restaurants() {
        events = new EventListenerList();
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public Restaurant choose() {
        return restaurants.get(random.nextInt(restaurants.size()));
    }

    public Optional<Restaurant> choose(Predicate<Restaurant> filter) {
        if(restaurants.stream().anyMatch(filter)) {
            List<Restaurant> filteredRestaurants = restaurants.stream().filter(filter).collect(Collectors.toList());

            int selectedIndex = random.nextInt(filteredRestaurants.size());

            return Optional.of(filteredRestaurants.get(selectedIndex));
        }
        else {
            return Optional.empty();
        }
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
        onRestaurantAdded(restaurant);
    }

    public Restaurant removeRestaurant(Restaurant restaurant) {
        if(restaurants.remove(restaurant)){
            onRestaurantRemoved(restaurant);
        }

        return restaurant;
    }

    public void addRestaurantListener(IRestaurantsListener listener) {
        events.add(IRestaurantsListener.class, listener);
    }

    public void removeRestaurantListener(IRestaurantsListener listener) {
        events.remove(IRestaurantsListener.class, listener);
    }

    private void onRestaurantAdded(Restaurant added) {
        Object[] listeners = events.getListenerList();

        for (int i = 0; i < listeners.length; i+=2) {
            if(listeners[i] == IRestaurantsListener.class) {
                ((IRestaurantsListener) listeners[i + 1])
                        .restaurantAdded(this, added);
            }
        }
    }

    private void onRestaurantRemoved(Restaurant removed) {
        Object[] listeners = events.getListenerList();

        for (int i = 0; i < listeners.length; i+=2) {
            if(listeners[i] == IRestaurantsListener.class) {
                ((IRestaurantsListener) listeners[i + 1])
                        .restaurantRemoved(this, removed);
            }
        }
    }
}
