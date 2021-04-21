package view;

import model.IRestaurantsListener;
import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ButtonPanel extends JPanel implements IButtonPanel {

    private final EventListenerList events;
    private final JButton choose;
    private final JButton selectAll;
    private final JButton selectNone;
    private final JButton addAnother;

    public ButtonPanel() {
        events = new EventListenerList();

        choose = new JButton("Choose!");
        selectAll = new JButton("Select All");
        selectNone = new JButton("Select None");
        addAnother = new JButton("Add Another");

        choose.setHorizontalAlignment(SwingConstants.CENTER);
        selectAll.setHorizontalAlignment(SwingConstants.CENTER);
        selectNone.setHorizontalAlignment(SwingConstants.CENTER);
        addAnother.setHorizontalAlignment(SwingConstants.CENTER);

        setupLayout();

        registerEvents();
    }

    private void setupLayout(){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        Dimension dimension = new Dimension(50, 10);
        add(Box.createHorizontalStrut(10));
        add(choose);
        add(Box.createRigidArea(dimension));
        add(selectAll);
        add(Box.createRigidArea(dimension));
        add(selectNone);
        add(Box.createRigidArea(dimension));
        add(addAnother);
        add(Box.createHorizontalStrut(10));
        registerEvents();
    }

    private void registerEvents() {
        choose.addActionListener(this::onAction);
        selectAll.addActionListener(this::onAction);
        selectNone.addActionListener(this::onAction);
        addAnother.addActionListener(this::onAction);
    }

    @Override
    public void addButtonPanelListener(IButtonPanelListener listener) {
        events.add(IButtonPanelListener.class, listener);
    }

    @Override
    public void removeButtonPanelListener(IButtonPanelListener listener) {
        events.remove(IButtonPanelListener.class, listener);
    }

    private void onAction(ActionEvent e) {
        Object[] listeners = events.getListenerList();
        Object source = e.getSource();

        for (int i = 0; i < listeners.length; i+=2) {
            if(listeners[i + 1] instanceof IButtonPanelListener) {

                IButtonPanelListener listener = (IButtonPanelListener) listeners[i + 1];

                if(source == choose) {
                    listener.chooseClicked(this);
                }
                else if(source == selectAll) {
                    listener.selectAllClicked(this);
                }
                else if(source == selectNone) {
                    listener.selectNoneClicked(this);
                }
                else {
                    listener.addAnotherClicked(this);
                }
            }
        }
    }
}