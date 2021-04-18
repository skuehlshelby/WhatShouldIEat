package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ChoicePanel extends JPanel implements IChoicePanel {
    private final JLabel choice;
    private final JButton chooseAgain;

    public ChoicePanel() {
        choice = new JLabel();
        chooseAgain = new JButton("Choose Again!");

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("You should eat..."));
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(choice);

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
