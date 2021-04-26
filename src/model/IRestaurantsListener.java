package model;

import java.util.EventListener;

/**
 * @author Scott Kuehl-Shelby
 */
public interface IRestaurantsListener extends EventListener {
    void restaurantAdded(Object sender, Restaurant restaurant);

    void restaurantRemoved(Object sender, Restaurant restaurant);
}
