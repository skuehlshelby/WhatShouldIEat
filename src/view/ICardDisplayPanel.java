package view;

import java.util.List;

public interface ICardDisplayPanel {
    List<RestaurantCard> getCards();

    void addCard(IRestaurantCard card);

    void removeCard(IRestaurantCard card);
}
