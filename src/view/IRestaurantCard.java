package view;

import java.awt.event.ActionListener;
import java.util.List;

public interface IRestaurantCard
{
    String getRestaurantName();

    void setRestaurantName(String name);

    List<String> getRestaurantItems();

    void addRestaurantItem(String item);

    void removeRestaurantItem(String item);

    void addSelectClickListener(ActionListener listener);

    void removeSelectClickListener(ActionListener listener);

    void addEditClickListener(ActionListener listener);

    void removeEditClickListener(ActionListener listener);
}
