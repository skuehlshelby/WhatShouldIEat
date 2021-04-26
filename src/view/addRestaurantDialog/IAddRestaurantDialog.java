package view.addRestaurantDialog;

import java.util.List;
import java.util.Optional;

/**
 * @author Scott Kuehl-Shelby
 */
public interface IAddRestaurantDialog {
    void display();

    void addRestaurantDialogListener(IAddRestaurantDialogListener listener);

    void removeRestaurantDialogListener(IAddRestaurantDialogListener listener);

    void enableOkay();

    void disableOkay();

    Optional<String> getRestaurantName();

    Optional<String> getCuisine();

    Optional<String> getStreet();

    Optional<String> getCity();

    Optional<String> getState();

    Optional<String> getZip();

    void addMenuItem(String item);

    List<String> getMenuItems();

    void displayErrors(List<String> errors);

    boolean isCancelled();
}
