package As4.Model.options;

import java.awt.*;
import As4.Model.BackgroundOption;
/**
 * Implementation of the BackgroundOption interface which
 * makes the top-right half of a box (including the main diagonal)
 * be of a given color; the bottom-left will be white.
 */
public class TriangleBackgroundOption implements BackgroundOption {
    private final Color color;

    public TriangleBackgroundOption(Color color) {
        this.color = color;
    }

    @Override
    public Color getColorAt(int row, int col, int width, int height) {
        double diagonal = (double) height / width;
        double expectedRow = diagonal * col;
        return (row <= expectedRow) ? color : Color.WHITE;
    }
}
