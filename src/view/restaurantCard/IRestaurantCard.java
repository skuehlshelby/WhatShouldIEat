package view.restaurantCard;

import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author Scott Kuehl-Shelby
 */
public interface IRestaurantCard
{
    String getRestaurantName();

    void setRestaurantName(String name);

    List<String> getRestaurantItems();

    void setSelected(boolean selected);

    boolean getSelected();

    void addRestaurantItem(String item);

    void removeRestaurantItem(String item);

    void addSelectClickListener(ActionListener listener);

    void removeSelectClickListener(ActionListener listener);

    void addEditClickListener(ActionListener listener);

    void removeEditClickListener(ActionListener listener);
}
