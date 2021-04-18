package view;

import model.MenuItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class MenuItemDialogTest {

    @Test
    void display() {
        IMenuItemDialog menuItemDialog = new MenuItemDialog();
        menuItemDialog.addChangeListener(this::EnableIfOkay);
        menuItemDialog.display();

        if(!menuItemDialog.isCancelled()) {
            MenuItem menuItem = new MenuItem(menuItemDialog.getItemName().get());

            menuItemDialog.getItemPrice().ifPresent(price -> menuItem.setPrice(Double.parseDouble(price)));
        }
    }

    private void EnableIfOkay(MenuItemDialogChangeEvent e) {
        IMenuItemDialog source = (IMenuItemDialog) e.getSource();

        if(MenuItem.validate(e.getMenuItemName(), e.getMenuItemPrice()).isEmpty()) {
            source.enableOkay();
        }
        else {
            source.disableOkay();
            source.displayErrors(MenuItem.validate(e.getMenuItemName(), e.getMenuItemPrice()));
        }
    }
}