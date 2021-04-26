package view;

import java.util.EventListener;

/**
 * @author Scott Kuehl-Shelby
 */
@FunctionalInterface
public interface IMenuItemDialogChangeEventListener extends EventListener {
    void onChange(MenuItemDialogChangeEvent event);
}
