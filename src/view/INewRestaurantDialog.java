package view;

import java.util.List;
import java.util.Optional;

public interface INewRestaurantDialog {
    void display();

    void addChangeListener(IRestaurantDialogChangeEventListener listener);

    void removeChangeListener(IRestaurantDialogChangeEventListener listener);

    void enableOkay();

    void disableOkay();

    Optional<String> getRestaurantName();

    Optional<String> getCuisine();

    Optional<String> getStreet();

    Optional<String> getCity();

    Optional<String> getState();

    Optional<String> getZip();

    List<String> getMenuItems();

    void displayErrors(List<String> errors);

    void addMenuItem(String item);

    boolean isCancelled();
}
