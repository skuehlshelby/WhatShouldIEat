package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CardDisplayPanel extends JPanel implements ICardDisplayPanel {
    private final JScrollPane scrollPane;
    private final JPanel scrollPaneInterior;

    public CardDisplayPanel(RestaurantCard... cards) {
        scrollPaneInterior = new JPanel();
        scrollPaneInterior.setLayout(new BoxLayout(scrollPaneInterior, BoxLayout.PAGE_AXIS));

        for(RestaurantCard card : cards)
        {
            scrollPaneInterior.add(card);
            scrollPaneInterior.add(Box.createRigidArea(new Dimension(50, 10)));
        }

        scrollPane = new JScrollPane(scrollPaneInterior);
        scrollPane.createVerticalScrollBar();

        setLayout(new GridBagLayout());
        add(scrollPane, new GridBagConstraintBuilder(0,0).fillVerticallyAndHorizontally().build());
    }

    @Override
    public List<RestaurantCard> getCards() {
        List<RestaurantCard> cards = new ArrayList<>();

        for(Component component : scrollPaneInterior.getComponents()){
            if(component instanceof RestaurantCard) {
                cards.add((RestaurantCard) component);
            }
        }

        return cards;
    }

    @Override
    public void addCard(IRestaurantCard card) {
        scrollPaneInterior.add((RestaurantCard) card);
    }

    @Override
    public void removeCard(IRestaurantCard card) {
        scrollPaneInterior.remove((Component) card);
    }
}
