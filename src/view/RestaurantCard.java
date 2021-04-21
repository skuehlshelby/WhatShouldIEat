package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantCard extends JPanel implements IRestaurantCard {
    private final JCheckBox selected;
    private final JButton edit;
    private final JLabel restaurantName;
    private final List<JLabel> items;
    private final BorderLayout layout;

    public RestaurantCard(String name, String... items) {
        layout = new BorderLayout();
        selected = new JCheckBox();
        edit = new JButton("Edit");
        restaurantName = new JLabel(name);
        this.items = Arrays.stream(items).map(JLabel::new).collect(Collectors.toList());

        setLayout(layout);
        add(selected, BorderLayout.LINE_START);
        add(edit, BorderLayout.LINE_END);
        add(restaurantName, BorderLayout.CENTER);
        this.items.forEach(item -> add(item, BorderLayout.SOUTH));
    }

    @Override
    public String getRestaurantName() {
        return restaurantName.getText();
    }

    @Override
    public void setRestaurantName(String name) {
        restaurantName.setText(name);
    }

    @Override
    public List<String> getRestaurantItems() {
        return items.stream().map(JLabel::getText).collect(Collectors.toList());
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected.setSelected(selected);
    }

    @Override
    public boolean getSelected() {
        return this.selected.isSelected();
    }

    @Override
    public void addRestaurantItem(String item) {
        items.add(new JLabel(item));
    }

    @Override
    public void removeRestaurantItem(String item) {
        items.removeIf(i -> i.getText().equals(item));
    }

    @Override
    public void addSelectClickListener(ActionListener listener) {
        selected.addActionListener(listener);
    }

    @Override
    public void removeSelectClickListener(ActionListener listener) {
        selected.removeActionListener(listener);
    }

    @Override
    public void addEditClickListener(ActionListener listener) {
        edit.addActionListener(listener);
    }

    @Override
    public void removeEditClickListener(ActionListener listener) {
        edit.removeActionListener(listener);
    }
}