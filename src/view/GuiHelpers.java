package view;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GuiHelpers {
    public enum GridWeight {
        TINY(1), SMALL(2), REGULAR(3), LARGE(4), HUGE(5);

        private final int size;

        GridWeight(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }
    }

    public static GridBagConstraints getConstraints(int row, int column) {
        return getConstraints(row, column, GridWeight.REGULAR, GridWeight.REGULAR);
    }

    public static GridBagConstraints getConstraints(int row, int column, GridWeight rowWeight) {
        return getConstraints(row, column, rowWeight, GridWeight.REGULAR);
    }

    public static GridBagConstraints getConstraints(int row, int column, GridWeight rowWeight, GridWeight columnWeight) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = row;
        constraints.gridx = column;
        constraints.weighty = rowWeight.getSize();
        constraints.weightx = columnWeight.getSize();

        return constraints;
    }

    public static JLabel getLabel(String label) {
        return new JLabel(label);
    }

    public static JTextField getTextField() {
        return getTextField("");
    }

    public static JTextField getTextField(int width) {
        return getTextField("", width);
    }

    public static JTextField getTextField(String placeholderText) {
        return getTextField(placeholderText, placeholderText.length() + 2);
    }

    public static JTextField getTextField(String placeholderText, int width) {
        JTextField textField = new JTextField(placeholderText);
        textField.setColumns(width);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        return textField;
    }

    public static JComboBox getComboBox(String...comboBoxItems) {
        JComboBox comboBox = new JComboBox(comboBoxItems);
        ((JLabel)comboBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        return comboBox;
    }

    public static JComboBox getComboBox(int width, String...comboBoxItems) {
        JComboBox comboBox = new JComboBox(comboBoxItems);
        ((JLabel)comboBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        char[] chars = new char[width];
        Arrays.fill(chars, 'Q');
        comboBox.setPrototypeDisplayValue(new String(chars));
        return comboBox;
    }
}
