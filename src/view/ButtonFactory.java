package view;

import javax.swing.*;
import java.awt.*;

public class ButtonFactory
{
    public static JButton makeButton(String text)
    {
        JButton button = new JButton(text);
        button.setFocusable(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        return button;
    }
}
