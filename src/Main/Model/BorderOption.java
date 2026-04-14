package As4.Model;

import As4.UI.Canvas;

/**
 * Interface to define an option for the border.
 */
public interface BorderOption {
    void drawBorder(Canvas canvas, int top, int left, int width, int height);
}