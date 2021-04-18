package view;

import java.util.EventListener;

@FunctionalInterface
public interface IRestaurantDialogChangeEventListener extends EventListener {
    void onChange(RestaurantDialogChangeEvent event);
}