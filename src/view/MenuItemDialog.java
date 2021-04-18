package view;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

public class MenuItemDialog extends JDialog implements IMenuItemDialog {
    private final EventListenerList events;
    private final Timer timer;
    private final JLabel errorDisplay;
    private final JLabel nameLabel;
    private final JTextField nameInput;
    private final JLabel priceLabel;
    private final JTextField priceInput;
    private final JButton okay;
    private final JButton cancel;
    private boolean cancelled;

    public MenuItemDialog() {
        timer = new Timer();
        events = new EventListenerList();
        cancelled = true;

        errorDisplay = new JLabel();

        nameLabel = new JLabel("Name: ");
        nameInput = new JTextField();
        nameInput.setColumns(20);

        priceLabel = new JLabel("Price: ");
        priceInput = new JTextField();
        priceInput.setColumns(20);

        okay = new JButton("OK");
        okay.setEnabled(false);
        cancel = new JButton("Cancel");

        okay.addActionListener(this::onOkayClick);
        cancel.addActionListener(this::onCancelClick);
        nameInput.addActionListener(this::fireChangeEvents);
        priceInput.addActionListener(this::fireChangeEvents);

        setupLayout();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setModal(true);
    }

    private void setupLayout() {
        setTitle("New Menu Item");
        Dimension dimension = getPreferredSize();
        dimension.setSize(400, 200);
        setPreferredSize(dimension);

        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = 2;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;

        errorDisplay.setHorizontalTextPosition(SwingConstants.CENTER);
        errorDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        errorDisplay.setOpaque(true);
        errorDisplay.setBackground(Color.RED);
        errorDisplay.setForeground(Color.RED.darker());
        errorDisplay.setVisible(false);
        add(errorDisplay, constraints);

        constraints.fill = GridBagConstraints.NONE;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;

        add(nameLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 1;
        constraints.weighty = 1;

        add(priceLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.weightx = 1;
        constraints.weighty = 1;

        add(okay, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;

        add(nameInput, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.weightx = 1;
        constraints.weighty = 1;

        add(priceInput, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.weightx = 1;
        constraints.weighty = 1;

        add(cancel, constraints);
    }

    private void fireChangeEvents(ActionEvent e) {
        Object[] listeners = events.getListenerList();

        for (int i = 0; i < listeners.length; i+=2) {
            if(listeners[i] == IMenuItemDialogChangeEventListener.class) {
                ((IMenuItemDialogChangeEventListener) listeners[i + 1])
                        .onChange(new MenuItemDialogChangeEvent(this, getItemName().orElse(null), getItemPrice().orElse(null)));
            }
        }
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
    public void addChangeListener(IMenuItemDialogChangeEventListener listener) {
        events.add(IMenuItemDialogChangeEventListener.class, listener);
    }

    @Override
    public void removeChangeListener(IMenuItemDialogChangeEventListener listener) {
        events.remove(IMenuItemDialogChangeEventListener.class, listener);
    }

    @Override
    public Optional<String> getItemName() {
        return Optional.ofNullable(nameInput.getText().length() == 0 ? null : nameInput.getText());
    }

    @Override
    public Optional<String> getItemPrice() {
        return Optional.ofNullable(priceInput.getText().length() == 0 ? null : priceInput.getText());
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void display() {
        setSize(getPreferredSize());
        setVisible(true);
    }

    @Override
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

    private void onOkayClick(ActionEvent e) {
        cancelled = false;
        setVisible(false);
    }

    private void onCancelClick(ActionEvent e) {
        cancelled = true;
        setVisible(false);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        timer.cancel();
    }
}