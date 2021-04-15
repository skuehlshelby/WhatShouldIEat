package view;

import model.MenuItem;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemDialogTest {

    @Test
    void display() {
        IMenuItemDialog menuItemDialog = new MenuItemDialog();
        menuItemDialog.addChangeListener(this::EnableIfOkay);
        menuItemDialog.display();

        if(!menuItemDialog.isCancelled()) {
            MenuItem menuItem = new MenuItem(menuItemDialog.getItemName().get());

            menuItemDialog.getItemPrice().ifPresent(price -> menuItem.setPrice(BigDecimal.valueOf(Double.parseDouble(price))));
        }

    }

    private void EnableIfOkay(MenuItemDialogChangeEvent e) {
        IMenuItemDialog source = (IMenuItemDialog) e.getSource();

        if(MenuItem.isValid(e.getMenuItemName(), e.getMenuItemPrice()).isEmpty()) {
            source.enableOkay();
        }
        else {
            source.disableOkay();
            source.displayErrors(MenuItem.isValid(e.getMenuItemName(), e.getMenuItemPrice()));
        }
    }
}