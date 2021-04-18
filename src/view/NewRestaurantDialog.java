package view;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import java.util.Timer;
import java.util.stream.Collectors;

public class NewRestaurantDialog extends JDialog implements INewRestaurantDialog {
    private final EventListenerList events;
    private final Timer timer;
    private final JLabel errorDisplay;
    private final JLabel nameLabel;
    private final JLabel cuisineLabel;
    private final JLabel addressLabel;
    private final JTextField name;
    private final JComboBox cuisine;
    private final JTextField street;
    private final JTextField city;
    private final JTextField state;
    private final JTextField zip;
    private final JButton addMenuItem;
    private final JPanel itemDisplayPanel;
    private final List<JLabel> items;
    private final JButton okay;
    private final JButton cancel;
    private boolean cancelled;

    public NewRestaurantDialog(String... cuisineChoices) {
        timer = new Timer();
        events = new EventListenerList();
        cancelled = true;
        errorDisplay = new JLabel();

        nameLabel = new JLabel("Name: ");
        cuisineLabel = new JLabel("Cuisine: ");
        addressLabel = new JLabel("Address: ");
        name = GuiHelpers.getTextField(20);
        cuisine = GuiHelpers.getComboBox(22, cuisineChoices);
        street = GuiHelpers.getTextField("Street", 20);
        city = GuiHelpers.getTextField("City", 20);
        state = GuiHelpers.getTextField("State", 3);
        zip = GuiHelpers.getTextField("Zip", 5);
        addMenuItem = new JButton("Add Menu Item");
        itemDisplayPanel = new JPanel();
        items = new ArrayList<>();

        okay = new JButton("OK");
        okay.setEnabled(false);

        cancel = new JButton("Cancel");

        setupLayout();

        registerEvents();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setModal(true);
    }

    private void setupLayout() {
        setTitle("Add New Restaurant");
        Dimension dimension = getPreferredSize();
        dimension.setSize(800, 300);
        setPreferredSize(dimension);

        setLayout(new GridBagLayout());

        //Error display bar
        errorDisplay.setHorizontalTextPosition(SwingConstants.CENTER);
        errorDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        errorDisplay.setOpaque(true);
        errorDisplay.setBackground(Color.RED);
        errorDisplay.setForeground(Color.RED.darker());
        errorDisplay.setVisible(false);
        add(errorDisplay, new GridBagConstraintBuilder(0, 0).fillHorizontally().spanXNumberOfColumns(5).build());

        //Left-most Column
        add(nameLabel, new GridBagConstraintBuilder(0, 1).alignRight().build());

        add(cuisineLabel, new GridBagConstraintBuilder(0, 2).alignRight().build());

        add(addressLabel, new GridBagConstraintBuilder(0, 3).alignRight().build());

        add(addMenuItem, new GridBagConstraintBuilder(0, 4).build());

        add(okay, new GridBagConstraintBuilder(0, 5).build());

        add(cancel, new GridBagConstraintBuilder(0, 6).build());

        //Second Column
        add(name, new GridBagConstraintBuilder(1, 1).alignLeft().build());

        add(cuisine, new GridBagConstraintBuilder(1, 2).alignLeft().build());

        //Menu Item Display Area
        itemDisplayPanel.setBorder(BorderFactory.createTitledBorder("Menu Items:"));
        itemDisplayPanel.add(new JLabel("Nothing to display yet..."));
        itemDisplayPanel.setLayout(new BoxLayout(itemDisplayPanel, BoxLayout.PAGE_AXIS));
        add(itemDisplayPanel, new GridBagConstraintBuilder(1, 4).fillVerticallyAndHorizontally().spanXNumberOfColumns(4).spanXNumberOfRows(3).build());

        //Address
        add(street, new GridBagConstraintBuilder(1, 3).alignLeft().build());

        add(city, new GridBagConstraintBuilder(2, 3).alignLeft().build());

        add(state, new GridBagConstraintBuilder(3, 3).alignLeft().columnWeight(GridBagConstraintBuilder.TINY).build());

        add(zip, new GridBagConstraintBuilder(4, 3).alignLeft().columnWeight(GridBagConstraintBuilder.SMALL).build());
    }

    private void registerEvents() {
        okay.addActionListener(this::okayClick);
        cancel.addActionListener(this::cancelClick);

        name.addActionListener(this::fireChangeEvents);
        cuisine.addActionListener(this::fireChangeEvents);
        street.addActionListener(this::fireChangeEvents);
        city.addActionListener(this::fireChangeEvents);
        state.addActionListener(this::fireChangeEvents);
        zip.addActionListener(this::fireChangeEvents);
    }

    private void cancelClick(ActionEvent e) {
        cancelled = true;
        setVisible(false);
    }

    private void okayClick(ActionEvent e) {
        cancelled = false;
        setVisible(false);
    }

    @Override
    public void display() {
        setSize(getPreferredSize());
        setVisible(true);
    }

    @Override
    public void addChangeListener(IRestaurantDialogChangeEventListener listener) {
        events.add(IRestaurantDialogChangeEventListener.class, listener);
    }

    @Override
    public void removeChangeListener(IRestaurantDialogChangeEventListener listener) {
        events.remove(IRestaurantDialogChangeEventListener.class, listener);
    }

    @Override
    public void enableOkay() {
        okay.setEnabled(true);
    }

    @Override
    public void disableOkay() {
        okay.setEnabled(false);
    }

    @Override
    public Optional<String> getRestaurantName() {
        return name.getText().length() == 0 ? Optional.empty() : Optional.of(name.getText());
    }

    @Override
    public Optional<String> getCuisine() {
        return Optional.ofNullable((String)cuisine.getSelectedItem());
    }

    @Override
    public Optional<String> getStreet() {
        return street.getText().length() == 0 ? Optional.empty() : Optional.of(street.getText());
    }

    @Override
    public Optional<String> getCity() {
        return city.getText().length() == 0 ? Optional.empty() : Optional.of(city.getText());
    }

    @Override
    public Optional<String> getState() {
        return state.getText().length() == 0 ? Optional.empty() : Optional.of(state.getText());
    }

    @Override
    public Optional<String> getZip() {
        return zip.getText().length() == 0 ? Optional.empty() : Optional.of(zip.getText());
    }

    @Override
    public List<String> getMenuItems() {
        return items.stream()
                .map(JLabel::getText)
                .filter(item -> !item.isEmpty())
                .collect(Collectors.toList());
    }

    public void displayErrors(List<String> errors) {
        errorDisplay.setText(String.join("\n", errors));
        errorDisplay.setVisible(true);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                errorDisplay.setVisible(false);
            }
        }, 3000);
    }

    @Override
    public void addMenuItem(String item) {
        if(items.isEmpty()) {
            itemDisplayPanel.removeAll();
        }

        JLabel newItem = new JLabel(item);
        items.add(newItem);
        itemDisplayPanel.add(newItem);
    }

    private void fireChangeEvents(ActionEvent e) {
        Object[] listeners = events.getListenerList();

        for (int i = 0; i < listeners.length; i+=2) {
            if(listeners[i] == INewRestaurantDialog.class) {
                ((IRestaurantDialogChangeEventListener) listeners[i + 1])
                        .onChange(new RestaurantDialogChangeEvent(this,
                                getRestaurantName().orElse(null),
                                getCuisine().orElse(null),
                                getStreet().orElse(null),
                                getCity().orElse(null),
                                getState().orElse(null),
                                getZip().orElse(null),
                                getMenuItems()));
            }
        }
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }
}