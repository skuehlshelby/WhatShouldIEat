package view;

import java.util.EventListener;

@FunctionalInterface
public interface IMenuItemDialogChangeEventListener extends EventListener {
    void onChange(MenuItemDialogChangeEvent event);
}
