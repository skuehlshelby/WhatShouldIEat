package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ChoicePanel extends JPanel implements IChoicePanel {

    private final JButton chooseAgain;

    public ChoicePanel(String choice) {
        chooseAgain = new JButton("Choose Again!");

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("You should eat..."));
        panel.add(new JLabel(choice));

        add(panel);
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
