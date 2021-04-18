package view;

import java.util.EventObject;
import java.util.List;
import java.util.Optional;

public class RestaurantDialogChangeEvent extends EventObject {
    private final String name;
    private final String cuisine;
    private final String street;
    private final String city;
    private final String state;
    private final String zip;
    private final List<String> menuItems;

    public RestaurantDialogChangeEvent(Object source, String name, String cuisine, String street, String city, String state, String zip, List<String> menuItems) {
        super(source);
        this.name = name;
        this.cuisine = cuisine;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.menuItems = menuItems;
    }

    public Optional<String> getRestaurantName() {
        return name.length() == 0 ? Optional.empty() : Optional.of(name);
    }

    public Optional<String> getCuisine() {
        return cuisine.length() == 0 ? Optional.empty() : Optional.of(cuisine);
    }

    public Optional<String> getStreet() {
        return street.length() == 0 ? Optional.empty() : Optional.of(street);
    }

    public Optional<String> getCity() {
        return city.length() == 0 ? Optional.empty() : Optional.of(city);
    }

    public Optional<String> getState() {
        return state.length() == 0 ? Optional.empty() : Optional.of(state);
    }

    public Optional<String> getZip() {
        return zip.length() == 0 ? Optional.empty() : Optional.of(zip);
    }

    public List<String> getMenuItems() {
        return menuItems;
    }
}
