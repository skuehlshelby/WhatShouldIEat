package view.freshStartPanel;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FreshStartPanel extends JPanel implements IFreshStartPanel {
    private final EventListenerList events;
    private final JLabel prompt;
    private final JButton loadFromFile;
    private final JButton addNew;

    public FreshStartPanel() {
        events = new EventListenerList();
        prompt = new JLabel("Track your favorite restaurants:");
        loadFromFile = new JButton("Load from file...");
        addNew = new JButton("Add a new restaurant...");

        registerEvents();

        Dimension dimension = new Dimension(50, 10);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createHorizontalStrut(10));
        add(loadFromFile);
        add(Box.createRigidArea(dimension));
        add(addNew);
        add(Box.createHorizontalStrut(10));
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
