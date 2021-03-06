package view;

import view.restaurantCard.IRestaurantCard;
import view.restaurantCard.RestaurantCard;

import java.util.List;

/**
 * @author Scott Kuehl-Shelby
 */
public interface ICardDisplayPanel {
    List<RestaurantCard> getCards();

    void addCard(IRestaurantCard card);

    void removeCard(IRestaurantCard card);
}
