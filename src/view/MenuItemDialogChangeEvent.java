package view;

import java.util.EventObject;

/**
 * @author Scott Kuehl-Shelby
 */
public class MenuItemDialogChangeEvent extends EventObject {

    private final String menuItemName;
    private final String menuItemPrice;

    public MenuItemDialogChangeEvent(Object source, String menuItemName, String menuItemPrice) {
        super(source);

        this.menuItemName = menuItemName;
        this.menuItemPrice = menuItemPrice;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public String getMenuItemPrice() {
        return menuItemPrice;
    }
}
