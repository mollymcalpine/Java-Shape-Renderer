package Main.Model.options;

import java.awt.*;
import Main.Model.BackgroundOption;

/**
 * Implementation of the BackgroundOption interface which
 * makes the entire background of a box, including border
 * and middle, be a given color.
 */
public class SolidBackgroundOption implements BackgroundOption {
    private final Color color;

    public SolidBackgroundOption(Color color) {
        this.color = color;
    }

    @Override
    public Color getColorAt(int row, int col, int width, int height) {
        return color;
    }
}
