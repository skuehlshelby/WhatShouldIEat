package view.addRestaurantDialog;

import java.util.EventListener;

public interface IAddRestaurantDialogListener extends EventListener {
    void nameChanged(Object sender, String name);
    void cuisineChanged(Object sender, String cuisine);
    void streetChanged(Object sender, String street);
    void cityChanged(Object sender, String city);
    void stateChanged(Object sender, String state);
    void zipChanged(Object sender, String zip);
}
