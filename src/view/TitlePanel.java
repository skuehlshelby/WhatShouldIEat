package view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Scott Kuehl-Shelby
 */
public class TitlePanel extends JPanel {
    private final JLabel title;

    public TitlePanel() {
        Font font = new Font(Font.SERIF, Font.PLAIN, 28);

        title = new JLabel("What Should I Eat?");
        title.setFont(font);
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setVerticalTextPosition(SwingConstants.CENTER);

        add(title);
    }
}
