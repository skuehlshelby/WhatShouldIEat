package view;

import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GuiTests
{
    @Test
    public void showRestaurantCard()
    {
        JFrame frame = new JFrame("What Should I Eat?");
        Dimension dimension = new Dimension(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(dimension);
        frame.add(new RestaurantCard("Westside Coffee", "16 oz Big Truck", "Asiago Bagel"));
        frame.pack();
        frame.setVisible(true);
    }

    @Test
    public void showTwoCardsInsideAScrollPane()
    {
        IRestaurantCard westSide = new RestaurantCard("Westside Coffee", "16 oz Big Truck", "Asiago Bagel");
        IRestaurantCard hermsInn = new RestaurantCard("Herms Inn", "Cinnamon swirl pancake", "Greek Skillet");

        JPanel scrollPanelInterior = new JPanel();
        scrollPanelInterior.setLayout(new BoxLayout(scrollPanelInterior, BoxLayout.PAGE_AXIS));
        scrollPanelInterior.add((Component) westSide);
        scrollPanelInterior.add((Component) hermsInn);

        JScrollPane scrollPane = new JScrollPane(scrollPanelInterior);

        JFrame frame = new JFrame("What Should I Eat?");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dimension = new Dimension(600, 400);
        frame.setSize(dimension);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }

    @Test
    public void showButtonPanel()
    {
        ButtonPanel buttonPanel = new ButtonPanel();

        JFrame frame = new JFrame("What Should I Eat?");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(buttonPanel);
        frame.pack();
        frame.setVisible(true);
    }

    @Test
    public void swapDataPanelViews()
    {
        JPanel mainPanel = new JPanel();

        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new CardLayout());

        FreshStartPanel freshStartPanel = new FreshStartPanel();
        CardDisplayPanel cardDisplayPanel = new CardDisplayPanel();
        cardDisplayPanel.addCard(new RestaurantCard("Westside Coffee", "Coffee", "Bagel"));
        cardDisplayPanel.addCard(new RestaurantCard("Westside Coffee", "Coffee", "Bagel"));

        cardPanel.add(freshStartPanel, "FreshStartPanel");
        cardPanel.add(cardDisplayPanel, "CardDisplayPanel");

        mainPanel.add(cardPanel);

        JFrame frame = new JFrame("What Should I Eat?");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);

        CardLayout c = (CardLayout) cardPanel.getLayout();
        c.show(cardPanel, "CardDisplayPanel");
    }
}