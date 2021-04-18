package view;

import java.awt.*;

public class GridBagConstraintBuilder {
    public static final int TINY = 1;
    public static final int SMALL = 2;
    public static final int NORMAL = 4;
    public static final int LARGE = 8;
    public static final int HUGE = 16;

    private final GridBagConstraints constraints = new GridBagConstraints();

    public GridBagConstraintBuilder(int column, int row) {
        constraints.gridy = row;
        constraints.gridx = column;
        constraints.weightx = NORMAL;
        constraints.weighty = NORMAL;
    }

    public GridBagConstraints build() {
        return constraints;
    }

    public GridBagConstraintBuilder rowWeight(int weight) {
        constraints.weighty = weight;
        return this;
    }

    public GridBagConstraintBuilder columnWeight(int weight) {
        constraints.weightx = weight;
        return this;
    }

    public GridBagConstraintBuilder fillHorizontally() {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        return this;
    }

    public GridBagConstraintBuilder fillVertically() {
        constraints.fill = GridBagConstraints.VERTICAL;
        return this;
    }

    public GridBagConstraintBuilder fillVerticallyAndHorizontally() {
        constraints.fill = GridBagConstraints.BOTH;
        return this;
    }

    public GridBagConstraintBuilder alignLeft() {
        constraints.anchor = GridBagConstraints.WEST;
        return this;
    }

    public GridBagConstraintBuilder alignRight() {
        constraints.anchor = GridBagConstraints.EAST;
        return this;
    }

    public GridBagConstraintBuilder spanXNumberOfColumns(int numberOfColumnsToSpan) {
        constraints.gridwidth = numberOfColumnsToSpan;
        return this;
    }

    public GridBagConstraintBuilder spanXNumberOfRows(int numberOfRowsToSpan) {
        constraints.gridheight = numberOfRowsToSpan;
        return this;
    }
}
