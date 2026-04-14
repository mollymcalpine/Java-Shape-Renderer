package Main.Model;

import java.awt.*;

/**
 * Interface to define an option for the background.
 */
public interface BackgroundOption {
    Color getColorAt(int row, int col, int width, int height);
}