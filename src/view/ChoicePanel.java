package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChoicePanel extends JPanel implements IChoicePanel {
    private final JLabel choice;
    private final JButton chooseAgain;

    public ChoicePanel() {
        choice = new JLabel();
        chooseAgain = new JButton("Choose Again!");

        setupLayout();
    }

    private void setupLayout(){
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("You should eat..."));
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        Dimension dimension = choice.getPreferredSize();
        dimension.setSize(200, 75);
        choice.setPreferredSize(dimension);
        choice.setHorizontalAlignment(SwingConstants.CENTER);
        choice.setVerticalAlignment(SwingConstants.CENTER);

        panel.add(Box.createHorizontalStrut(10));
        panel.add(choice);
        panel.add(Box.createHorizontalStrut(10));

        chooseAgain.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(panel);
        add(chooseAgain);
    }

    @Override
    public void setChoice(String choice) {
        this.choice.setText(choice);
    }

    @Override
    public void addChooseAgainActionListener(ActionListener listener) {
        chooseAgain.addActionListener(listener);
    }

    @Override
    public void removeChooseAgainActionListener(ActionListener listener) {
        chooseAgain.addActionListener(listener);
    }
}
