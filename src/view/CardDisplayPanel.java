package view;

import javax.swing.*;
import java.awt.*;

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

        add(scrollPane);
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
