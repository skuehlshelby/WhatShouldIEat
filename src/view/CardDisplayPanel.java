package view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardDisplayPanel extends JPanel implements ICardDisplayPanel {
    private final List<RestaurantCard> cards;
    private final JScrollPane scrollPane;
    private final JPanel scrollPaneInterior;

    public CardDisplayPanel(RestaurantCard... cards) {
        this.cards = new ArrayList<>(Arrays.asList(cards));

        scrollPaneInterior = new JPanel();
        scrollPaneInterior.setLayout(new BoxLayout(scrollPaneInterior, BoxLayout.PAGE_AXIS));

        this.cards.forEach(scrollPaneInterior::add);

        scrollPane = new JScrollPane(scrollPaneInterior);
    }

    @Override
    public void addCard(IRestaurantCard card) {
        cards.add((RestaurantCard) card);
    }

    @Override
    public boolean removeCard(IRestaurantCard card) {
        return cards.remove((RestaurantCard) card);
    }
}
