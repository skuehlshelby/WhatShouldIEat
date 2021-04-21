package model;

import java.util.EventListener;

public interface IRestaurantListener extends EventListener {
    void nameChanged(Object sender, String name);
    void addressChanged(Object sender, Address address);
    void menuItemAdded(Object sender, MenuItem menuItem);
}
