package view.restaurantCard;

import view.GridBagConstraintBuilder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Scott Kuehl-Shelby
 */
public class RestaurantCard extends JPanel implements IRestaurantCard {
    private final JCheckBox selected;
    private final JButton edit;
    private final JLabel restaurantName;
    private final List<JLabel> items;

    public RestaurantCard(String name, String... items) {
        selected = new JCheckBox();
        edit = new JButton("Edit");
        restaurantName = new JLabel(name);
        this.items = Arrays.stream(items).map(JLabel::new).collect(Collectors.toList());

        setupLayout();
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        restaurantName.setHorizontalAlignment(SwingConstants.CENTER);
        restaurantName.setHorizontalTextPosition(SwingConstants.CENTER);

        add(selected, new GridBagConstraintBuilder(0, 0).rowWeight(GridBagConstraintBuilder.TINY).columnWeight(GridBagConstraintBuilder.TINY).build());
        add(restaurantName, new GridBagConstraintBuilder(1, 1).fillHorizontally().build());
        add(edit, new GridBagConstraintBuilder(2, 0).rowWeight(GridBagConstraintBuilder.TINY).columnWeight(GridBagConstraintBuilder.TINY).build());

        if(!items.isEmpty()) {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.PAGE_AXIS));
            items.forEach(itemPanel::add);

            add(itemPanel, new GridBagConstraintBuilder(1, 2).fillHorizontally().build());
        }
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