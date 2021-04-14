package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel implements IButtonPanel {

    private final JButton choose;
    private final JButton selectAll;
    private final JButton selectNone;
    private final JButton addAnother;

    public ButtonPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        choose = new JButton("Choose!");
        selectAll = new JButton("Select All");
        selectNone = new JButton("Select None");
        addAnother = new JButton("Add Another");

        choose.setHorizontalAlignment(SwingConstants.CENTER);
        selectAll.setHorizontalAlignment(SwingConstants.CENTER);
        selectNone.setHorizontalAlignment(SwingConstants.CENTER);
        addAnother.setHorizontalAlignment(SwingConstants.CENTER);

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
    }

    @Override
    public void addChooseClickListener(ActionListener listener) {
        choose.addActionListener(listener);
    }

    @Override
    public void removeChooseClickListener(ActionListener listener) {
        choose.removeActionListener(listener);
    }

    @Override
    public void addSelectAllClickListener(ActionListener listener) {
        selectAll.addActionListener(listener);
    }

    @Override
    public void removeSelectAllClickListener(ActionListener listener) {
        selectAll.removeActionListener(listener);
    }

    @Override
    public void addSelectNoneClickListener(ActionListener listener) {
        selectNone.addActionListener(listener);
    }

    @Override
    public void removeSelectNoneClickListener(ActionListener listener) {
        selectNone.removeActionListener(listener);
    }

    @Override
    public void addAddAnotherClickListener(ActionListener listener) {
        addAnother.addActionListener(listener);
    }

    @Override
    public void removeAddAnotherClickListener(ActionListener listener) {
        addAnother.removeActionListener(listener);
    }
}
