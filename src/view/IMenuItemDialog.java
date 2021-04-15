package view;

import java.util.List;
import java.util.Optional;

public interface IMenuItemDialog {
    void addChangeListener(IMenuItemDialogChangeEventListener listener);

    void removeChangeListener(IMenuItemDialogChangeEventListener listener);

    Optional<String> getItemName();

    Optional<String> getItemPrice();

    void enableOkay();

    void disableOkay();

    boolean isCancelled();

    void display();

    void displayErrors(List<String> errors);
}
