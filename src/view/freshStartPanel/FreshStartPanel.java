package view.freshStartPanel;

import view.GridBagConstraintBuilder;
import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Scott Kuehl-Shelby
 */
public class FreshStartPanel extends JPanel implements IFreshStartPanel {
    private final EventListenerList events;
    private final JButton loadFromFile;
    private final JButton addNew;

    public FreshStartPanel() {
        events = new EventListenerList();
        loadFromFile = new JButton("Load from file...");
        addNew = new JButton("Add a new restaurant...");

        registerEvents();

        setupLayout();
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        add(Box.createVerticalStrut(10), new GridBagConstraintBuilder(0, 0).columnWeight(GridBagConstraintBuilder.LARGE).spanXNumberOfRows(5).build());

        add(Box.createHorizontalStrut(10), new GridBagConstraintBuilder(1, 0).rowWeight(GridBagConstraintBuilder.HUGE).build());
        add(loadFromFile, new GridBagConstraintBuilder(1, 1).fillHorizontally().rowWeight(GridBagConstraintBuilder.SMALL).build());
        add(Box.createRigidArea(new Dimension(10, 5)), new GridBagConstraintBuilder(1, 2).fillHorizontally().rowWeight(GridBagConstraintBuilder.TINY).build());
        add(addNew, new GridBagConstraintBuilder(1, 3).fillHorizontally().rowWeight(GridBagConstraintBuilder.SMALL).build());
        add(Box.createHorizontalStrut(10), new GridBagConstraintBuilder(1, 4).rowWeight(GridBagConstraintBuilder.HUGE).build());

        add(Box.createVerticalStrut(10), new GridBagConstraintBuilder(2, 0).columnWeight(GridBagConstraintBuilder.LARGE).spanXNumberOfRows(5).build());
    }

    private void registerEvents() {
        loadFromFile.addActionListener(this::fireEvents);
        addNew.addActionListener(this::fireEvents);
    }

    private void fireEvents(ActionEvent e) {
        Object[] listeners = events.getListenerList();
        Object source = e.getSource();

        for (int i = 0; i < listeners.length; i+=2) {
            if(listeners[i] == IFreshStartPanelListener.class) {
                IFreshStartPanelListener listener = (IFreshStartPanelListener) listeners[i + 1];

                if(source == loadFromFile) {
                    listener.loadFromFileClicked(this);
                }
                else {
                    listener.addAnotherClicked(this);
                }
            }
        }
    }

    @Override
    public void addFreshStartPanelListener(IFreshStartPanelListener listener) {
        events.add(IFreshStartPanelListener.class, listener);
    }

    @Override
    public void removeFreshStartPanelListener(IFreshStartPanelListener listener) {
        events.remove(IFreshStartPanelListener.class, listener);
    }
}
