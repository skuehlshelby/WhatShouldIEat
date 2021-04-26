package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Scott Kuehl-Shelby
 */
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
        panel.setLayout(new GridBagLayout());

        choice.setFont(new Font(Font.SERIF, Font.BOLD, 18));
        choice.setHorizontalTextPosition(SwingConstants.CENTER);
        choice.setVerticalTextPosition(SwingConstants.CENTER);
        choice.setHorizontalAlignment(SwingConstants.CENTER);
        choice.setVerticalAlignment(SwingConstants.CENTER);

        panel.add(choice, new GridBagConstraintBuilder(0, 0).fillVerticallyAndHorizontally().build());

        chooseAgain.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new GridBagLayout());
        add(panel, new GridBagConstraintBuilder(0,0).rowWeight(GridBagConstraintBuilder.HUGE).fillVerticallyAndHorizontally().build());
        add(chooseAgain, new GridBagConstraintBuilder(0, 1).rowWeight(GridBagConstraintBuilder.TINY).build());
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
