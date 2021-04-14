package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FreshStartPanel extends JPanel implements IFreshStartPanel {
    private final JLabel prompt;
    private final JButton loadFromFile;
    private final JButton addNew;

    public FreshStartPanel() {
        prompt = new JLabel("Track your favorite restaurants:");
        loadFromFile = new JButton("Load from file...");
        addNew = new JButton("Add a new restaurant...");

        Dimension dimension = new Dimension(50, 10);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createHorizontalStrut(10));
        add(loadFromFile);
        add(Box.createRigidArea(dimension));
        add(addNew);
        add(Box.createHorizontalStrut(10));
    }

    @Override
    public void addLoadFromFileClickListener(ActionListener listener) {
        loadFromFile.addActionListener(listener);
    }

    @Override
    public void removeLoadFromFileClickListener(ActionListener listener) {
        loadFromFile.removeActionListener(listener);
    }

    @Override
    public void addAddNewClickListener(ActionListener listener) {
        addNew.addActionListener(listener);
    }

    @Override
    public void removeAddNewClickListener(ActionListener listener) {
        addNew.removeActionListener(listener);
    }
}
