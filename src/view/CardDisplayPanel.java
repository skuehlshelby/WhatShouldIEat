package view;

import view.restaurantCard.IRestaurantCard;
import view.restaurantCard.RestaurantCard;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Scott Kuehl-Shelby
 */
public class CardDisplayPanel extends JPanel implements ICardDisplayPanel {
    private final JScrollPane scrollPane;
    private final List<RestaurantCard> cards;
    private final JPanel scrollPaneInterior;

    public CardDisplayPanel(RestaurantCard... cards) {
        this.cards = new ArrayList<>();

        scrollPaneInterior = new JPanel();
        scrollPaneInterior.setLayout(new BoxLayout(scrollPaneInterior, BoxLayout.PAGE_AXIS));

        for(RestaurantCard card : cards)
        {
            addCard(card);
        }

        scrollPane = new JScrollPane(scrollPaneInterior);
        scrollPane.createVerticalScrollBar();

        setLayout(new GridBagLayout());
        add(scrollPane, new GridBagConstraintBuilder(0,0).fillVerticallyAndHorizontally().build());
    }

    @Override
    public List<RestaurantCard> getCards() {
        return cards;
    }

    @Override
    public void addCard(IRestaurantCard card) {
        cards.add((RestaurantCard) card);
        arrangeCards();
    }

    @Override
    public void removeCard(IRestaurantCard card) {
        scrollPaneInterior.remove((Component) card);
    }

    private void arrangeCards(){
        scrollPaneInterior.removeAll();

        scrollPaneInterior.add(Box.createVerticalStrut(100));

        for (int card = 0; card < getCards().size(); card++) {
            scrollPaneInterior.add(getCards().get(card));

            if(card != getCards().size() - 1) {
                scrollPaneInterior.add(Box.createRigidArea(new Dimension(10, 10)));
            }
        }

        scrollPaneInterior.add(Box.createVerticalStrut(100));
    }
}
