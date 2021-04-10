package view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainForm
{
    private final JPanel content;
    private final JPanel buttonPanel;
    private final JButton choose;
    private final JButton selectAll;
    private final JButton selectNone;
    private final JButton addAnother;

    private final JPanel cardPanel;
    private final JScrollPane cardScrollArea;
    private final List<RestaurantCard> cards;

    public MainForm()
    {
        content = new JPanel();
        buttonPanel = new JPanel();
        cardPanel = new JPanel();

        cardScrollArea = new JScrollPane();

        cards = new ArrayList<>();

        choose = ButtonFactory.makeButton("Choose!");
        selectAll = ButtonFactory.makeButton("Select All");
        selectNone = ButtonFactory.makeButton("Select None");
        addAnother = ButtonFactory.makeButton("Add Another");

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.add(choose);
        buttonPanel.add(selectAll);
        buttonPanel.add(selectNone);
        buttonPanel.add(addAnother);
    }

    public void registerChooseClickListener(ActionListener listener)
    {
        choose.addActionListener(listener);
    }

    public void registerSelectAllClickListener(ActionListener listener)
    {
        selectAll.addActionListener(listener);
    }

    public void registerSelectNoneClickListener(ActionListener listener)
    {
        selectNone.addActionListener(listener);
    }

    public void registerAddAnotherClickListener(ActionListener listener)
    {
        addAnother.addActionListener(listener);
    }

    public void addCard(RestaurantCard card)
    {
        cards.add(card);
        reDraw();
    }

    public RestaurantCard removeCard(RestaurantCard card)
    {
        RestaurantCard removed = cards.remove(cards.indexOf(card));
        reDraw();
        return removed;
    }

    private void reDraw()
    {
        content.revalidate();
        content.repaint();
    }

    public JPanel getContent()
    {
        return content;
    }
}
