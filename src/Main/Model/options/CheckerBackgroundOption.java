package Main.Model.options;

import java.awt.*;
import Main.Model.BackgroundOption;

/**
 * Implementation of the BackgroundOption interface which
 * makes the background of a box have a checkerboard pattern.
 * The top left cell is of a given color, and
 * alternates with white to make a checkerboard.
 */
public class CheckerBackgroundOption implements BackgroundOption {
    private final Color color;

    public CheckerBackgroundOption(Color color) {
        this.color = color;
    }

    @Override
    public Color getColorAt(int row, int col, int width, int height) {
        return ((row + col) % 2 == 0) ? color : Color.WHITE;
    }
}